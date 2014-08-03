package stuff;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProcessorTests {

    Queue<Instruction> instructions;
    MipsProcessor processor;

    @Before
    public void setup() {
        instructions = new LinkedBlockingQueue<Instruction>();
        instructions.add(new Instruction("00000000001000101000000000100000"));
        instructions.add(new Instruction("00100000011100000000000000000100"));
        instructions.add(new Instruction("00001000000000000000000000000010"));
        processor = new MipsProcessor(instructions);
    }

    @Test
    public void executeFirstCycle(){

    }
}
