package stuff;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Owner on 8/4/2014.
 */
public class Main {
    public static void main(String [] args) {
        String instructionsFile = "C:\\Users\\Owner\\Documents\\instructions.txt";
        String memoryFile = "C:\\Users\\Owner\\Documents\\memory.txt";
        MipsProcessor proc = new MipsProcessor(instructionsFile, memoryFile);
        String userInput=null;

        proc.executeCycle();
        proc.executeCycle();
        proc.executeCycle();
        proc.executeCycle();
        //System.out.println("Enter when you want to stop: ");
        //Scanner reader = new Scanner(System.in);
        /*while (proc.currentInstruction !=null) {
            if (proc.currentInstruction.opCode == "R") {
                proc.executeCycle();
                proc.executeCycle();
                proc.executeCycle();
                proc.executeCycle();
            } else if (proc.currentInstruction.getOpCode() == "I") {
                proc.executeCycle();
                proc.executeCycle();
                proc.executeCycle();
            } else if (proc.currentInstruction.getOpCode() == "J") {
                proc.executeCycle();
                proc.executeCycle();
                proc.executeCycle();
            } else if (proc.currentInstruction.getOpCode() == "dataTransfer") {
                proc.executeCycle();
                proc.executeCycle();
                proc.executeCycle();
                proc.executeCycle();
                proc.executeCycle();
            }
        }*/

    }
}
