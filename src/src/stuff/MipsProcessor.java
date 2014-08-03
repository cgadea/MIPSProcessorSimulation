package stuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class MipsProcessor {

    Instruction[] instructions;
    List<Integer> aluOutputs;

    Instruction currentInstruction;
    ControlSignalSetting currentSetting;
    ProcessorState currentState;
    ProcessorRegisters processorRegisters;

    public MipsProcessor(Instruction[] instructions){
        currentState = ProcessorState.ZERO;
        processorRegisters = new ProcessorRegisters();

        this.instructions = instructions;
    }

    public MipsProcessor(String instructionsFile){
        currentState = ProcessorState.ZERO;
        processorRegisters = new ProcessorRegisters();

        instructions = new Instruction[100];
        int cnt = 0;
        File file = new File(instructionsFile);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                instructions[cnt] = new Instruction(line);
                cnt++;
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public void executeCycle(){
        if (currentState == ProcessorState.ZERO) {
            currentInstruction = instructions[processorRegisters.getPc()];
            processorRegisters.setAluOut(processorRegisters.getPc() + 1);
        } else if (currentState == ProcessorState.ONE) {
            int rs = currentInstruction.getRs();
            int rt = currentInstruction.getRt();
            if (currentInstruction.getOpCode().equals("R")) {
                processorRegisters.setA(processorRegisters.getMemoryAt(rs));
                processorRegisters.setB(processorRegisters.getMemoryAt(rt));
            } else if (currentInstruction.getOpCode().equals("I")) {
                if (currentInstruction.getFunctI() == "BEQ" || currentInstruction.getFunctI() == "BNE") {
                    processorRegisters.setAluOut(processorRegisters.getPc() + currentInstruction.getImmediate());
                } else {
                    processorRegisters.setA(processorRegisters.getMemoryAt(rs));
                }
            }
        } else if (currentState == ProcessorState.TWO) {
            if (currentInstruction.getOpCode().equals("dataTransfer")) {
                processorRegisters.setAluOut(processorRegisters.getA() + currentInstruction.getImmediate());
            }
        } else if (currentState == ProcessorState.THREE) {
            processorRegisters.setAluOut(processorRegisters.getMemoryAt(currentInstruction.getRs()) + currentInstruction.getImmediate());
        } else if (currentState == ProcessorState.FOUR) {
            processorRegisters.setMemoryAt(currentInstruction.getRt(),processorRegisters.getAluOut());
        }

        currentState = currentState.nextState(currentInstruction);
    }

    public void setCurrentState(ProcessorState state){
        currentState = state;
    }

    public void setCurrentInstruction(Instruction instruction){
        currentInstruction = instruction;
    }

    public ProcessorRegisters getProcessorRegisters(){
        return processorRegisters;
    }

    public void setProcessorRegisters(ProcessorRegisters processorRegisters){
        this.processorRegisters = processorRegisters;
    }

    public ProcessorState getCurrentState() {
        return currentState;
    }
}
