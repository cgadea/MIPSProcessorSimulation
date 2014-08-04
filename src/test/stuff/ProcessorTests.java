package stuff;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProcessorTests {

    Instruction[] instructions;
    MipsProcessor processor;

    @Before
    public void setup() {
        instructions = new Instruction[100];
        instructions[0] = new Instruction("00000000001000101000000000100000");
        instructions[1] = new Instruction("00100000011100000000000000000100");
        instructions[2] = new Instruction("00001000000000000000000000000010");
        processor = new MipsProcessor(instructions);
    }

    @Test
    public void testInitializeFromFiles(){
        instructions = new Instruction[100];
        instructions[0] = new Instruction("00000000001000101000000000100000");
        instructions[1] = new Instruction("00100000011100000000000000000100");
        instructions[2] = new Instruction("00001000000000000000000000000010");
        String instructionsFile = "C:\\Users\\....";
        String memoryFile = "C...";
        processor = new MipsProcessor(instructionsFile, memoryFile);
        assertArrayEquals(new int[] {1,3,7},processor.getProcessorRegisters().getMemory());
        assertArrayEquals(instructions, processor.getInstructions());

    }

    @Test
    public void testStateGoesFromZeroToOneOnFirstCycle(){
        assertEquals(ProcessorState.ZERO,processor.getCurrentState());
        processor.executeCycle();
        assertEquals(ProcessorState.ONE,processor.getCurrentState());
        assertEquals(1,processor.getProcessorRegisters().getAluOut());
    }

    @Test
    public void testStateOneItypeLogic(){
        String binInstruction = "00010000001000100000000000000011";
        Instruction instruction = new Instruction(binInstruction);
        processor.setCurrentInstruction(instruction);
        processor.setCurrentState(ProcessorState.ONE);
        ProcessorRegisters registers = new ProcessorRegisters();
        registers.setPc(10);
        registers.setMemoryAt(1,99);
        registers.setMemoryAt(2,99);
        processor.setProcessorRegisters(registers);

        processor.executeCycle();

        processor.setCurrentState(ProcessorState.TWO);
        assertEquals(13,processor.getProcessorRegisters().getAluOut());
    }


    @Test
    public void testStateTwoLogic(){
        String binInstruction = "10001100110100100000000000000010";
        Instruction instruction = new Instruction(binInstruction);
        processor.setCurrentInstruction(instruction);
        processor.setCurrentState(ProcessorState.TWO);
        ProcessorRegisters registers = new ProcessorRegisters();
        registers.setA(5);
        processor.setProcessorRegisters(registers);

        processor.executeCycle();

        assertEquals(ProcessorState.THREE,processor.getCurrentState());
        assertEquals(7,processor.getProcessorRegisters().getAluOut());
    }

    @Test
    public void testStateThreeLogic(){
        String binInstruction = "10001100110100100000000000000010";
        Instruction instruction = new Instruction(binInstruction);
        processor.setCurrentInstruction(instruction);
        processor.setCurrentState(ProcessorState.THREE);
        ProcessorRegisters registers = new ProcessorRegisters();
        registers.setMemoryAt(6, 15);
        processor.setProcessorRegisters(registers);

        processor.executeCycle();

        assertEquals(ProcessorState.FOUR,processor.getCurrentState());
        assertEquals(17, processor.getProcessorRegisters().getAluOut());
    }

    @Test
    public void testStateFourLogic(){
        String binInstruction = "10001100110100100000000000000010";
        Instruction instruction = new Instruction(binInstruction);
        processor.setCurrentInstruction(instruction);
        processor.setCurrentState(ProcessorState.FOUR);
        ProcessorRegisters registers = new ProcessorRegisters();
        registers.setAluOut(12);
        processor.setProcessorRegisters(registers);

        processor.executeCycle();

        assertEquals(ProcessorState.ZERO,processor.getCurrentState());
        assertEquals(12,processor.getProcessorRegisters().getMemoryAt(instruction.getRt()));
    }
    /*@Test
    public void testStateFiveLogic(){
        String binInstruction = "10001100110100100000000000000010";
        Instruction instruction = new Instruction(binInstruction);
        processor.setCurrentInstruction(instruction);
        processor.setCurrentState(ProcessorState.FIVE);
        ProcessorRegisters registers = new ProcessorRegisters();
        registers.setAluOut(12);
        processor.setProcessorRegisters(registers);

        processor.executeCycle();

        assertEquals(ProcessorState.ZERO,processor.getCurrentState());
        assertEquals(12,processor.getProcessorRegisters().getMemoryAt(instruction.getRt()));
    }*/

    @Test
    public void testStateSixLogic(){
        String binInstruction = "00000000001000100001100010100111";
        Instruction instruction = new Instruction(binInstruction);
        processor.setCurrentInstruction(instruction);
        processor.setCurrentState(ProcessorState.SIX);
        ProcessorRegisters registers = new ProcessorRegisters();
        registers.setMemoryAt(1,6);
        registers.setMemoryAt(2, 5);
        processor.setProcessorRegisters(registers);

        processor.executeCycle();

        assertEquals(ProcessorState.SEVEN,processor.getCurrentState());
        assertEquals(24,processor.getProcessorRegisters().getAluOut());
    }

    @Test
    public void testStateSevenLogic(){
        String binInstruction = "00000000001000100001100010000000";
        Instruction instruction = new Instruction(binInstruction);
        processor.setCurrentInstruction(instruction);
        processor.setCurrentState(ProcessorState.SEVEN);
        ProcessorRegisters registers = new ProcessorRegisters();
        registers.setAluOut(10);
        processor.setProcessorRegisters(registers);

        processor.executeCycle();

        assertEquals(ProcessorState.ZERO,processor.getCurrentState());
        assertEquals(10,processor.getProcessorRegisters().getMemoryAt(instruction.getRd()));
    }
    @Test
    public void testStateEightLogic(){
        String binInstruction = "00110100001000100000000000001100";
        Instruction instruction = new Instruction(binInstruction);
        processor.setCurrentInstruction(instruction);
        processor.setCurrentState(ProcessorState.EIGHT);
        ProcessorRegisters registers = new ProcessorRegisters();
        registers.setMemoryAt(1,2);
        registers.setMemoryAt(2,5);
        registers.setPc(2);
        processor.setProcessorRegisters(registers);

        processor.executeCycle();

        assertEquals(ProcessorState.ZERO,processor.getCurrentState());
        assertEquals(14,processor.getProcessorRegisters().getAluOut());
    }

    @Test
    public void testStateNineLogic(){
        String binInstruction = "00001000000000000000000000000011";
        Instruction instruction = new Instruction(binInstruction);
        processor.setCurrentInstruction(instruction);
        processor.setCurrentState(ProcessorState.NINE);
        ProcessorRegisters registers = new ProcessorRegisters();
        processor.setProcessorRegisters(registers);

        processor.executeCycle();

        assertEquals(ProcessorState.ZERO,processor.getCurrentState());
        assertEquals(3,processor.getProcessorRegisters().getPc());
    }
}