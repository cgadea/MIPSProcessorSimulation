package stuff;

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
        assertEquals(17,processor.getProcessorRegisters().getAluOut());
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
}
