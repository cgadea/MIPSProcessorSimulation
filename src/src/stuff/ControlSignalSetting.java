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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ControlSignalSetting that = (ControlSignalSetting) o;

        if (aluOp != that.aluOp) return false;
        if (aluSrcA != that.aluSrcA) return false;
        if (aluSrcB != that.aluSrcB) return false;
        if (iOrD != that.iOrD) return false;
        if (irWrite != that.irWrite) return false;
        if (memRead != that.memRead) return false;
        if (memWrite != that.memWrite) return false;
        if (memtoReg != that.memtoReg) return false;
        if (pcSource != that.pcSource) return false;
        if (pcWrite != that.pcWrite) return false;
        if (regDst != that.regDst) return false;
        if (regWrite != that.regWrite) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (regDst ? 1 : 0);
        result = 31 * result + (regWrite ? 1 : 0);
        result = 31 * result + (aluSrcA ? 1 : 0);
        result = 31 * result + (memRead ? 1 : 0);
        result = 31 * result + (memWrite ? 1 : 0);
        result = 31 * result + (memtoReg ? 1 : 0);
        result = 31 * result + (iOrD ? 1 : 0);
        result = 31 * result + (irWrite ? 1 : 0);
        result = 31 * result + (pcWrite ? 1 : 0);
        result = 31 * result + aluOp;
        result = 31 * result + aluSrcB;
        result = 31 * result + pcSource;
        return result;
    }
}
