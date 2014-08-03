package stuff;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProcessorStateTests {

    @Test
    public void stateZeroYieldsStateOne(){
        Instruction instruction = new Instruction("00000000001000101000000000100000");
        assertEquals(ProcessorState.ONE, ProcessorState.ZERO.nextState(instruction));
    }

    @Test
    public void stateEightReturnsCorrectSetting(){
        ControlSignalSetting beqSetting = new ControlSignalSetting(false,false,true,false,false,false,false,false,false,0,0,1);
        assertEquals(beqSetting, ProcessorState.EIGHT.getSetting("BEQ"));
        ControlSignalSetting addiSetting = new ControlSignalSetting(false,false,true,false,false,false,false,false,false,0,2,1);
        assertEquals(addiSetting, ProcessorState.EIGHT.getSetting("ADDI"));
    }

}
