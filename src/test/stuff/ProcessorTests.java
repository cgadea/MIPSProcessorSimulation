package stuff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class ProcessorTests {

    MipsProcessor myProcessor;

    @Before
    public void setup(){
        myProcessor = new MipsProcessor("C:\\Users\\Owner\\Documents\\dev\\instructions.txt");
    }

    @Test
    public void duringCycleOneInstructionIsLoadedFromMemory(){
        /*
        assertNull(myProcessor.getCurrentInstruction());
        myProcessor.runCycleOne();
        assertEquals("add $s1 $s3 $s3", myProcessor.getCurrentInstruction());
        */
    }

    @Test
    public void duringCycleOneProgramCounterIncrements(){

    }
}
