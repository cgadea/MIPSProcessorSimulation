package stuff;


public class State {
    //Set all variables
    public Boolean RegDst = false;
    public Boolean RegWrite = false;
    public Boolean ALUSrcA = false;
    public Boolean MemRead = true;
    public Boolean MemWrite = false;
    public Boolean MemtoReg = false;
    public Boolean IorD = false;
    public Boolean IRWrite = true;
    public Boolean PCWrite = true;
    public char ALUOp = 0;
    public char ALUSrcB = 1;
    public char PCSource = 0;

    // IorD = 0, decode by calling Mux1
    //Get instruction address if MemRead = 1
    //Store in AddrMem
    //Get instruction
    //Store in Inst. Register when IRWrite = 1
    //ALUSrcA = 0 & ALUOp = 00 so ALU is called
    //PCWrite = 1 increment PC by 1

}
