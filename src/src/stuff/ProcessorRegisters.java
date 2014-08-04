package stuff;

public class ProcessorRegisters {
    int aluOut;
    int memoryAddress; //0,1,2,.. refers to item in instruction list
    int pc;
    int a;
    int b;

    int[] memory = new int[100];

    public int getMemoryAt(int i) {
        return memory[i];
    }

    public void setMemoryAt(int i, int val) {
        memory[i] = val;
    }

    public ProcessorRegisters() {
        aluOut = 0;
        pc = 0;
        //initialize memory
    }

    public void setMemory(int[] memory){
        this.memory = memory;
    }

    public int[] getMemory(){
        return memory;
    }

    public int getAluOut() {
        return aluOut;
    }

    public void setAluOut(int aluOut) {
        this.aluOut = aluOut;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getMemoryAddress() {
        return memoryAddress;
    }

    public void setMemoryAddress(int memoryAddress) {
        this.memoryAddress = memoryAddress;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
