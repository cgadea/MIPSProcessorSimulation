package stuff;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProcessorTests {

    @Test
    public void processorSaysHello() {
        assertEquals("Hello World!", MipsProcessor.giveHello());
    }

}
