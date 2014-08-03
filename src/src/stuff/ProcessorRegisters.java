package stuff;

public class ProcessorRegisters {
    int memoryAddress; //0,1,2,.. refers to item in instruction list

    public ProcessorRegisters() {}

    public int getMemoryAddress() {
        return memoryAddress;
    }

    public void setMemoryAddress(int memoryAddress) {
        this.memoryAddress = memoryAddress;
    }
}
