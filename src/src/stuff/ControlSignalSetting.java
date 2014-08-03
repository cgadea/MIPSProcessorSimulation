package stuff;

public class ControlSignalSetting {
    boolean regDst;
    boolean regWrite;
    boolean aluSrcA;
    boolean memRead;
    boolean memWrite;
    boolean memtoReg;
    boolean iOrD;
    boolean irWrite;
    boolean pcWrite;
    int aluOp;
    int aluSrcB;
    int pcSource;

    public ControlSignalSetting(boolean regDst, boolean regWrite, boolean aluSrcA, boolean memRead, boolean memWrite, boolean memtoReg, boolean iOrD, boolean irWrite, boolean pcWrite, int aluOp, int aluSrcB, int pcSource) {
        this.regDst = regDst;
        this.regWrite = regWrite;
        this.aluSrcA = aluSrcA;
        this.memRead = memRead;
        this.memWrite = memWrite;
        this.memtoReg = memtoReg;
        this.iOrD = iOrD;
        this.irWrite = irWrite;
        this.pcWrite = pcWrite;
        this.aluOp = aluOp;
        this.aluSrcB = aluSrcB;
        this.pcSource = pcSource;
    }
}
