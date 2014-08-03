package stuff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MipsProcessor {

    Queue<Instruction> instructions;
    List<Integer> aluOutputs;

    String currentInstruction;
    ControlSignalSetting currentSetting;
    ProcessorState currentState;
    ProcessorRegisters processorRegisters;

    public MipsProcessor(Queue<Instruction> instructions){
        currentState = ProcessorState.ZERO;
        processorRegisters = new ProcessorRegisters();

        this.instructions = instructions;
    }

    public MipsProcessor(String instructionsFile){
        currentState = ProcessorState.ZERO;
        processorRegisters = new ProcessorRegisters();

        instructions = new LinkedBlockingQueue<Instruction>();
        File file = new File(instructionsFile);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                instructions.add(new Instruction(line));
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public void executeCycle(){

    }
}
