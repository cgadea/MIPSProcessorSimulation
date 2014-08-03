package stuff;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProcessorStateTests {

    @Test
    public void stateZeroYieldsStateOne(){
        assertEquals(ProcessorState.ONE, ProcessorState.ZERO.nextState());
    }

}
