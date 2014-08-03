package stuff;

public class Instruction {
    String opCode;
    int rs;
    int rt;
    int rd;
    int shamt;
    String funct;
    String functI;
    int immediate;
    String jumpaddress;
    int cycle = 1;

    public String Instruction(String binaryInstruction) {
        int opCodeInt = Integer.parseInt(binaryInstruction.substring(0, 5), 2);
        if ((opCodeInt == 3) || (opCodeInt == 4) || (opCodeInt == 5) || (opCodeInt == 13) || (opCodeInt == 8)){
            opCode = "I";
            rs = Integer.parseInt(binaryInstruction.substring(6, 10), 2);
            rt = Integer.parseInt(binaryInstruction.substring(11, 15), 2);
            immediate = Integer.parseInt(binaryInstruction.substring(16, 31), 2);
            if (opCodeInt == 8){
                functI = "ADDI";
            } else if (opCodeInt == 13) {
                functI = "ORI";
            } else if (opCodeInt == 4) {
                functI = "BEQ";
            } else if (opCodeInt == 5) {
                functI = "BNE";
            } else if (opCodeInt == 3) {
                functI = "SRA";
            }
        }
        else if (opCodeInt == 0) {
            opCode = "R";
            rs = Integer.parseInt(binaryInstruction.substring(6, 10), 2);
            rt = Integer.parseInt(binaryInstruction.substring(11, 15), 2);
            rd = Integer.parseInt(binaryInstruction.substring(16, 20), 2);
            shamt = Integer.parseInt(binaryInstruction.substring(21, 25), 2);
            int functInt = Integer.parseInt(binaryInstruction.substring(26, 31), 2);
            switch (functInt) {
                case 100000: funct = "ADD";
                    break;
                case 100010: funct = "SUB";
                    break;
                case 100111: funct = "NOR";
                    break;
                case 100100: funct = "AND";
                    break;
                case 000000: funct = "SLL";
                    break;
                case 000010: funct = "SRL";
                    break;
                default:     funct = "Invalid";
                    break;
            }
        }
        else if (opCodeInt == 2) {
            opCode = "J";
            jumpaddress = binaryInstruction.substring(6, 31);
        }
        else if ((opCodeInt == 35) || (opCodeInt == 43)){
            opCode = "dataTransfer";
            rs = Integer.parseInt(binaryInstruction.substring(6, 10), 2);
            rt = Integer.parseInt(binaryInstruction.substring(11, 15), 2);
            immediate = Integer.parseInt(binaryInstruction.substring(16, 31), 2);
            if (opCodeInt == 35){
                functI = "LW";
            } else if (opCodeInt == 43) {
                functI = "SW";
            }
        }
        else{
            opCode = "Invalid";
        }
    return opCode;
    }
}