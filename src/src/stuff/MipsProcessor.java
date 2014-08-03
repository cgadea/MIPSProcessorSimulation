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

    Queue<String> instructions;
    String currentInstruction;
    Boolean RegDst, RegWrite, ALUSrcA, MemRead;
    Boolean MemWrite, MemtoReg, IorD, IRWrite, PCWrite;
    char ALUOp, ALUSrcB, PCSource;

    //Call Cycle 1

    public MipsProcessor(String instructionsFile){
        instructions = new LinkedBlockingQueue<String>();

        File file = new File(instructionsFile);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                instructions.add(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
    //Input line as array
    //define opCode as array from [0]-[5]
    //define funct as array from [26]-[31]

    public void executeCycle(State state){

    }

/*
    public void runCycleOne(){
        setCurrentInstruction(instructions.remove());
    }

    public String getCurrentInstruction(){
        return currentInstruction;
    }

    public void setCurrentInstruction(String newInstruction){
        currentInstruction = newInstruction;
    }*/
}
