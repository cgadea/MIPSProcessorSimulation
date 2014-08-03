package stuff;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProcessorStateTests {

    @Test
    public void stateZeroYieldsStateOne(){
        Instruction instruction = new Instruction("00000000001000101000000000100000");
        assertEquals(ProcessorState.ONE, ProcessorState.ZERO.nextState(instruction));
    }

}
