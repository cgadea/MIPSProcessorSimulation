package stuff;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstructionTests {

    @Test
    public void correctlyParsesAddingOneToTwo(){
        String binInstruction = "00000000001000101000000000100000";
        Instruction inst = new Instruction(binInstruction);
        assertEquals("R", inst.getOpCode());
        assertEquals(1, inst.getRs());
        assertEquals(2, inst.getRt());
        assertEquals(16, inst.getRd());
        assertEquals("ADD", inst.getFunct());
        assertEquals(0, inst.getShamt());
    }

    @Test
    public void correctlyParsesAddingThreeToFourImmediately(){
        String binInstruction = "00100000011100000000000000000100";
        Instruction inst = new Instruction(binInstruction);
        assertEquals("I", inst.getOpCode());
        assertEquals(3, inst.getRs());
        assertEquals(4, inst.getImmediate());
        assertEquals(16, inst.getRt());
        assertEquals("ADDI", inst.getFunctI());
    }

    @Test
    public void correctlyParsesJumpingByTwoInstructions(){
        String binInstruction = "00001000000000000000000000000010";
        Instruction inst = new Instruction(binInstruction);
        assertEquals("J", inst.getOpCode());
        assertEquals(2, inst.getInstructionToSkip());
    }

    @Test
    public void correctlyParsesLoadWordInstruction(){
        String binInstruction = "10001100110100100000000000000000";
        Instruction inst = new Instruction(binInstruction);
        assertEquals("dataTransfer", inst.getOpCode());
        assertEquals(6, inst.getRs());
        assertEquals(18, inst.getRt());
        assertEquals(0, inst.getImmediate());
        assertEquals("LW", inst.getFunctI());
    }

    @Test
    public void correctlyParsesInvalidInstruction(){
        String binInstruction = "11111100000000000000000000000000";
        Instruction inst = new Instruction(binInstruction);
        assertEquals("Invalid", inst.getOpCode());
    }
}
