package stuff;

/**
 * Created by Owner on 8/2/2014.
 */
public class StateController {

    private String opCodeToOpType(int opCode){
        //if branch return class

        if ((opCode == 4) || (opCode == 5) || (opCode == 13) || (opCode == 8)){
            return "I";
        }
        else if ((opCode == 0)) {
            return "R";
        }
        else if ((opCode == 2)) {
            return "J";
        }
        else if ((opCode == 35) || (opCode == 43)){
            return "dataTransfer";
        }
        else{
            return "Invalid";
        }
    }

    public State ControlState(int opCode, int cycle){

        if (cycle == 1){
            State zero = new State();
            zero.RegDst = false;
            zero.RegWrite = false;
            zero.ALUSrcA = false;
            zero.MemRead = true;
            zero.MemWrite = false;
            zero.MemtoReg = false;
            zero.IorD = false;
            zero.IRWrite = true;
            zero.PCWrite = true;
            zero.ALUOp = 0;
            zero.ALUSrcB = 1;
            zero.PCSource = 0;
            return zero;
        }
        else if(cycle == 2){
            State zero = new State();
            zero.RegDst = false;
            zero.RegWrite = false;
            zero.ALUSrcA = false;
            zero.MemRead = false;
            zero.MemWrite = false;
            zero.MemtoReg = false;
            zero.IorD = false;
            zero.IRWrite = false;
            zero.PCWrite = false;
            zero.ALUOp =0;
            zero.ALUSrcB = 2;
            zero.PCSource = 0;
            return zero;
        }
        else if(cycle == 3){
            if (opCodeToOpType(opCode) == "J"){
                State zero = new State();
                zero.RegDst = false;
                zero.RegWrite = false;
                zero.ALUSrcA = false;
                zero.MemRead = false;
                zero.MemWrite = false;
                zero.MemtoReg = false;
                zero.IorD = false;
                zero.IRWrite = false;
                zero.PCWrite = true;
                zero.ALUOp =0;
                zero.ALUSrcB = 3;
                zero.PCSource = 2;
                return zero;
            }
            else if (opCodeToOpType(opCode) == "I"){
                //BEQ
                if (opCode == 4){
                    State zero = new State();
                    zero.RegDst = false;
                    zero.RegWrite = false;
                    zero.ALUSrcA = true;
                    zero.MemRead = false;
                    zero.MemWrite = false;
                    zero.MemtoReg = false;
                    zero.IorD = false;
                    zero.IRWrite = false;
                    zero.PCWrite = false;
                    zero.ALUOp = 1;
                    zero.ALUSrcB = 0;
                    zero.PCSource = 1;
                    return zero;
                }
                //BNE
                if (opCode == 5){
                    State zero = new State();
                    zero.RegDst = false;
                    zero.RegWrite = false;
                    zero.ALUSrcA = true;
                    zero.MemRead = false;
                    zero.MemWrite = false;
                    zero.MemtoReg = false;
                    zero.IorD = false;
                    zero.IRWrite = false;
                    zero.PCWrite = false;
                    zero.ALUOp = 1;
                    zero.ALUSrcB = 0;
                    zero.PCSource = 1;
                    return zero;
                }
                //ORI
                if (opCode == 13){
                    State zero = new State();
                    zero.RegDst = false;
                    zero.RegWrite = false;
                    zero.ALUSrcA = true;
                    zero.MemRead = false;
                    zero.MemWrite = false;
                    zero.MemtoReg = false;
                    zero.IorD = false;
                    zero.IRWrite = false;
                    zero.PCWrite = false;
                    zero.ALUOp = 1;
                    zero.ALUSrcB = 2;
                    zero.PCSource = 0;
                    return zero;
                }
                //ADDI
                if (opCode == 8){
                    State zero = new State();
                    zero.RegDst = false;
                    zero.RegWrite = false;
                    zero.ALUSrcA = true;
                    zero.MemRead = false;
                    zero.MemWrite = false;
                    zero.MemtoReg = false;
                    zero.IorD = false;
                    zero.IRWrite = true;
                    zero.PCWrite = true;
                    zero.ALUOp = 0;
                    zero.ALUSrcB = 2;
                    zero.PCSource = 0;
                    return zero;
                }

            }
            else if (opCodeToOpType(opCode) == "R"){

                //values for ADD
                if (instructionToFunct(functCode)== "ADD"){
                    State zero = new State();
                    zero.RegDst = true;
                    zero.RegWrite = true;
                    zero.ALUSrcA = true;
                    zero.MemRead = false;
                    zero.MemWrite = false;
                    zero.MemtoReg = false;
                    zero.IorD = false;
                    zero.IRWrite = false;
                    zero.PCWrite = false;
                    zero.ALUOp = 0;
                    zero.ALUSrcB = 0;
                    zero.PCSource = 0;
                    return zero;
                }
                //values for SUB
                if (instructionToFunct(functCode)== "SUB"){
                    State zero = new State();
                    zero.RegDst = true;
                    zero.RegWrite = true;
                    zero.ALUSrcA = true;
                    zero.MemRead = false;
                    zero.MemWrite = false;
                    zero.MemtoReg = false;
                    zero.IorD = false;
                    zero.IRWrite = false;
                    zero.PCWrite = false;
                    zero.ALUOp = 1;
                    zero.ALUSrcB = 0;
                    zero.PCSource = 0;
                    return zero;
                }
                //values for NOR
                if (instructionToFunct(functCode)== "NOR"){
                    State zero = new State();
                    zero.RegDst = true;
                    zero.RegWrite = true;
                    zero.ALUSrcA = true;
                    zero.MemRead = false;
                    zero.MemWrite = false;
                    zero.MemtoReg = false;
                    zero.IorD = false;
                    zero.IRWrite = false;
                    zero.PCWrite = false;
                    zero.ALUOp = 2;
                    zero.ALUSrcB = 0;
                    zero.PCSource = 0;
                    return zero;
                }
                //values for AND
                if (instructionToFunct(functCode)== "AND"){
                    State zero = new State();
                    zero.RegDst = true;
                    zero.RegWrite = true;
                    zero.ALUSrcA = true;
                    zero.MemRead = false;
                    zero.MemWrite = false;
                    zero.MemtoReg = false;
                    zero.IorD = false;
                    zero.IRWrite = false;
                    zero.PCWrite = false;
                    zero.ALUOp = 2;
                    zero.ALUSrcB = 0;
                    zero.PCSource = 0;
                    return zero;
                }
                //values for SLL
                if (instructionToFunct(functCode)== "SLL"){
                    State zero = new State();
                    zero.RegDst = true;
                    zero.RegWrite = true;
                    zero.ALUSrcA = true;
                    zero.MemRead = false;
                    zero.MemWrite = false;
                    zero.MemtoReg = false;
                    zero.IorD = false;
                    zero.IRWrite = false;
                    zero.PCWrite = false;
                    zero.ALUOp = 2;
                    zero.ALUSrcB = 0;
                    zero.PCSource = 0;
                    return zero;
                }
                //values for SRL
                if (instructionToFunct(functCode)== "SRL"){
                    State zero = new State();
                    zero.RegDst = true;
                    zero.RegWrite = true;
                    zero.ALUSrcA = true;
                    zero.MemRead = false;
                    zero.MemWrite = false;
                    zero.MemtoReg = false;
                    zero.IorD = false;
                    zero.IRWrite = false;
                    zero.PCWrite = false;
                    zero.ALUOp = 2;
                    zero.ALUSrcB = 0;
                    zero.PCSource = 0;
                    return zero;
                }
            }
            else if (opCodeToOpType(opCode) == "dataTransfer"){
                State zero = new State();
                zero.RegDst = false;
                zero.RegWrite = false;
                zero.ALUSrcA = true;
                zero.MemRead = false;
                zero.MemWrite = false;
                zero.MemtoReg = false;
                zero.IorD = false;
                zero.IRWrite = false;
                zero.PCWrite = false;
                zero.ALUOp =0;
                zero.ALUSrcB = 2;
                zero.PCSource = 0;
                return zero;
            }
            else if (opCodeToOpType(opCode) == "Invalid"){
                System.out.println("You dumb bitch this ain't no instruction!");
            }
        }
        else if (cycle == 4){
            //If it is store or load word:
            if (opCodeToOpType(opCode) == "dataTransfer"){
                //variable values for load word
                if (opCode == 35){
                    State zero = new State();
                    zero.RegDst = false;
                    zero.RegWrite = false;
                    zero.ALUSrcA = true;
                    zero.MemRead = true;
                    zero.MemWrite = false;
                    zero.MemtoReg = false;
                    zero.IorD = true;
                    zero.IRWrite = false;
                    zero.PCWrite = false;
                    zero.ALUOp = 0;
                    zero.ALUSrcB = 2;
                    zero.PCSource = 0;
                    return zero;
                }
                //variable values for store word
                else if (opCode == 43){
                    State zero = new State();
                    zero.RegDst = false;
                    zero.RegWrite = false;
                    zero.ALUSrcA = true;
                    zero.MemRead = false;
                    zero.MemWrite = true;
                    zero.MemtoReg = false;
                    zero.IorD = true;
                    zero.IRWrite = false;
                    zero.PCWrite = false;
                    zero.ALUOp = 0;
                    zero.ALUSrcB = 2;
                    zero.PCSource = 0;
                    return zero;
                }
            }
            else if (opCodeToOpType(opCode) == "R"){

            }
            else if (opCodeToOpType(opCode) == "I"){
            }
        }
    }
}
