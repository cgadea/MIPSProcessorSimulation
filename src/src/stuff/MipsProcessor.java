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

    public MipsProcessor(String instructionsFile, String memoryFile){
        currentState = ProcessorState.ZERO;
        processorRegisters = new ProcessorRegisters();

        instructions = new Instruction[100];
        int cnt = 0;
        File file = new File(instructionsFile);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                instructions[cnt] = new Instruction(line);
                System.out.println(instructions[cnt]);
                cnt++;
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        int[] memory = new int[100];
        cnt = 0;
        file = new File(memoryFile);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                memory[cnt] = Integer.parseInt(line);
                cnt++;
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        processorRegisters.setMemory(memory);
    }

    public Instruction[] getInstructions(){
        return instructions;
    }

    public void executeCycle(){
        if (currentState == ProcessorState.ZERO) {
            currentInstruction = instructions[processorRegisters.getPc()];
            if (currentInstruction == null){
                System.out.println("No more instructions!");
                System.exit(0);
            }
            processorRegisters.setAluOut(processorRegisters.getPc() + 1);
        } else if (currentState == ProcessorState.ONE) {
            int rs = currentInstruction.getRs();
            int rt = currentInstruction.getRt();
            if (currentInstruction.getOpCode().equals("R")) {
                processorRegisters.setA(processorRegisters.getMemoryAt(rs));
                processorRegisters.setB(processorRegisters.getMemoryAt(rt));
            } else if (currentInstruction.getOpCode().equals("I")) {
                if (currentInstruction.getFunctI() == "BEQ" || currentInstruction.getFunctI() == "BNE") {
                    processorRegisters.setPc(processorRegisters.getAluOut() + currentInstruction.getImmediate());
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
        else if (currentState == ProcessorState.FIVE) {
            processorRegisters.setMemoryAt(currentInstruction.getRt(),(processorRegisters.getMemoryAt(currentInstruction.getRs())+currentInstruction.getImmediate()));
        }else if (currentState == ProcessorState.SIX) {
            if (currentInstruction.getFunct() == "ADD"){
                processorRegisters.setAluOut(processorRegisters.getMemoryAt(currentInstruction.getRs())+processorRegisters.getMemoryAt(currentInstruction.getRt()));
            } else if (currentInstruction.getFunct() == "SUB"){
                processorRegisters.setAluOut(processorRegisters.getMemoryAt(currentInstruction.getRs())-processorRegisters.getMemoryAt(currentInstruction.getRt()));
            } else if (currentInstruction.getFunct() == "NOR"){
                int rsVal = processorRegisters.getMemoryAt(currentInstruction.getRs());
                int rtVal = processorRegisters.getMemoryAt(currentInstruction.getRt());
                int result = ~(rsVal|rtVal) & 0x0001F;
                processorRegisters.setAluOut(result);
            } else if (currentInstruction.getFunct() == "AND"){
                processorRegisters.setAluOut(processorRegisters.getMemoryAt(currentInstruction.getRs())&processorRegisters.getMemoryAt(currentInstruction.getRt()));
            } else if (currentInstruction.getFunct() == "SLL"){
                processorRegisters.setAluOut(processorRegisters.getMemoryAt(currentInstruction.getRs())<<currentInstruction.getShamt());
            } else if (currentInstruction.getFunct() == "SRL"){
                processorRegisters.setAluOut(processorRegisters.getMemoryAt(currentInstruction.getRs())>>currentInstruction.getShamt());
            }
        } else if (currentState == ProcessorState.SEVEN) {
            processorRegisters.setMemoryAt(currentInstruction.getRd(),processorRegisters.getAluOut());
        } else if (currentState == ProcessorState.EIGHT) {
            if (currentInstruction.getFunctI() == "BEQ"){
                processorRegisters.setAluOut(processorRegisters.getMemoryAt(currentInstruction.getRs())-processorRegisters.getMemoryAt(currentInstruction.getRt()));
                if (processorRegisters.getAluOut() == 0){
                    processorRegisters.setPc(processorRegisters.getPc()+currentInstruction.getImmediate());
                }
            } else if (currentInstruction.getFunctI() == "BNE"){
                processorRegisters.setAluOut(processorRegisters.getMemoryAt(currentInstruction.getRs())-processorRegisters.getMemoryAt(currentInstruction.getRt()));
                if (processorRegisters.getAluOut() != 0){
                    processorRegisters.setPc(processorRegisters.getPc()+currentInstruction.getImmediate());
                }
            } else if (currentInstruction.getFunctI() == "ORI"){
                processorRegisters.setAluOut(processorRegisters.getMemoryAt(currentInstruction.getRs())|currentInstruction.getImmediate());
            } else if (currentInstruction.getFunctI() == "ADDI"){
                processorRegisters.setAluOut(processorRegisters.getMemoryAt(currentInstruction.getRs())+currentInstruction.getImmediate());
            }
        } else if (currentState == ProcessorState.NINE) {
            processorRegisters.setPc(currentInstruction.getInstructionToSkip());
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