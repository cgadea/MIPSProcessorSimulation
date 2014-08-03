package stuff;

/**
 * Created by Owner on 8/2/2014.
 */
public class StateController {
    public State ControlState(int cycle) {
        Instruction Instruct = new Instruction();
        if (cycle == 1) {
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
            cycle++;
        } else if (cycle == 2) {
            State one = new State();
            one.RegDst = false;
            one.RegWrite = false;
            one.ALUSrcA = false;
            one.MemRead = false;
            one.MemWrite = false;
            one.MemtoReg = false;
            one.IorD = false;
            one.IRWrite = false;
            one.PCWrite = false;
            one.ALUOp = 0;
            one.ALUSrcB = 2;
            one.PCSource = 0;
            return one;
            cycle++;
        } else if (cycle == 3) {
            if (Instruct.opCode == "J") {
                State nine = new State();
                nine.RegDst = false;
                nine.RegWrite = false;
                nine.ALUSrcA = false;
                nine.MemRead = false;
                nine.MemWrite = false;
                nine.MemtoReg = false;
                nine.IorD = false;
                nine.IRWrite = false;
                nine.PCWrite = true;
                nine.ALUOp = 0;
                nine.ALUSrcB = 3;
                nine.PCSource = 2;
                return nine;
            } else if (Instruct.opCode == "I") {
                //BEQ
                if (Instruct.functI == "BEQ") {
                    State eight = new State();
                    eight.RegDst = false;
                    eight.RegWrite = false;
                    eight.ALUSrcA = true;
                    eight.MemRead = false;
                    eight.MemWrite = false;
                    eight.MemtoReg = false;
                    eight.IorD = false;
                    eight.IRWrite = false;
                    eight.PCWrite = false;
                    eight.ALUOp = 1;
                    eight.ALUSrcB = 0;
                    eight.PCSource = 1;
                    return eight;
                }
                //BNE
                if (Instruct.functI == "BNE") {
                    State eight = new State();
                    eight.RegDst = false;
                    eight.RegWrite = false;
                    eight.ALUSrcA = true;
                    eight.MemRead = false;
                    eight.MemWrite = false;
                    eight.MemtoReg = false;
                    eight.IorD = false;
                    eight.IRWrite = false;
                    eight.PCWrite = false;
                    eight.ALUOp = 1;
                    eight.ALUSrcB = 0;
                    eight.PCSource = 1;
                    return eight;
                }
                //ORI
                if (Instruct.functI == "ORI") {
                    State eight = new State();
                    eight.RegDst = false;
                    eight.RegWrite = false;
                    eight.ALUSrcA = true;
                    eight.MemRead = false;
                    eight.MemWrite = false;
                    eight.MemtoReg = false;
                    eight.IorD = false;
                    eight.IRWrite = false;
                    eight.PCWrite = false;
                    eight.ALUOp = 1;
                    eight.ALUSrcB = 2;
                    eight.PCSource = 0;
                    return eight;
                }
                //ADDI
                if (Instruct.functI == "ADDI") {
                    State eight = new State();
                    eight.RegDst = false;
                    eight.RegWrite = false;
                    eight.ALUSrcA = true;
                    eight.MemRead = false;
                    eight.MemWrite = false;
                    eight.MemtoReg = false;
                    eight.IorD = false;
                    eight.IRWrite = true;
                    eight.PCWrite = true;
                    eight.ALUOp = 0;
                    eight.ALUSrcB = 2;
                    eight.PCSource = 0;
                    return eight;
                }
                cycle++;

            } else if (Instruct.opCode == "R") {
                //values for ADD
                if (Instruct.funct == "ADD") {
                    State six = new State();
                    six.RegDst = true;
                    six.RegWrite = true;
                    six.ALUSrcA = true;
                    six.MemRead = false;
                    six.MemWrite = false;
                    six.MemtoReg = false;
                    six.IorD = false;
                    six.IRWrite = false;
                    six.PCWrite = false;
                    six.ALUOp = 0;
                    six.ALUSrcB = 0;
                    six.PCSource = 0;
                    return six;
                }
                //values for SUB
                if (Instruct.funct == "SUB") {
                    State six = new State();
                    six.RegDst = true;
                    six.RegWrite = true;
                    six.ALUSrcA = true;
                    six.MemRead = false;
                    six.MemWrite = false;
                    six.MemtoReg = false;
                    six.IorD = false;
                    six.IRWrite = false;
                    six.PCWrite = false;
                    six.ALUOp = 1;
                    six.ALUSrcB = 0;
                    six.PCSource = 0;
                    return six;
                }
                //values for NOR
                if (Instruct.funct == "NOR") {
                    State six = new State();
                    six.RegDst = true;
                    six.RegWrite = true;
                    six.ALUSrcA = true;
                    six.MemRead = false;
                    six.MemWrite = false;
                    six.MemtoReg = false;
                    six.IorD = false;
                    six.IRWrite = false;
                    six.PCWrite = false;
                    six.ALUOp = 2;
                    six.ALUSrcB = 0;
                    six.PCSource = 0;
                    return six;
                }
                //values for AND
                if (Instruct.funct == "AND") {
                    State six = new State();
                    six.RegDst = true;
                    six.RegWrite = true;
                    six.ALUSrcA = true;
                    six.MemRead = false;
                    six.MemWrite = false;
                    six.MemtoReg = false;
                    six.IorD = false;
                    six.IRWrite = false;
                    six.PCWrite = false;
                    six.ALUOp = 2;
                    six.ALUSrcB = 0;
                    six.PCSource = 0;
                    return six;
                }
                //values for SLL
                if (Instruct.funct == "SLL") {
                    State six = new State();
                    six.RegDst = true;
                    six.RegWrite = true;
                    six.ALUSrcA = true;
                    six.MemRead = false;
                    six.MemWrite = false;
                    six.MemtoReg = false;
                    six.IorD = false;
                    six.IRWrite = false;
                    six.PCWrite = false;
                    six.ALUOp = 2;
                    six.ALUSrcB = 0;
                    six.PCSource = 0;
                    return six;
                }
                //values for SRL
                if (Instruct.funct == "SRL") {
                    State six = new State();
                    six.RegDst = true;
                    six.RegWrite = true;
                    six.ALUSrcA = true;
                    six.MemRead = false;
                    six.MemWrite = false;
                    six.MemtoReg = false;
                    six.IorD = false;
                    six.IRWrite = false;
                    six.PCWrite = false;
                    six.ALUOp = 2;
                    six.ALUSrcB = 0;
                    six.PCSource = 0;
                    return six;
                }
            } else if (Instruct.opCode == "dataTransfer") {
                State two = new State();
                two.RegDst = false;
                two.RegWrite = false;
                two.ALUSrcA = true;
                two.MemRead = false;
                two.MemWrite = false;
                two.MemtoReg = false;
                two.IorD = false;
                two.IRWrite = false;
                two.PCWrite = false;
                two.ALUOp = 0;
                two.ALUSrcB = 2;
                two.PCSource = 0;
                return two;
            }
             else if (Instruct.opCode == "Invalid") {
                System.out.println("You dumb bitch this ain't no instruction!");
            }
            cycle++;
        } else if (cycle == 4) {
            //If it is store or load word:
            if (Instruct.opCode == "dataTransfer") {
                //variable values for load word
                if (Instruct.functI == "LW") {
                    State three = new State();
                    three.RegDst = false;
                    three.RegWrite = false;
                    three.ALUSrcA = true;
                    three.MemRead = true;
                    three.MemWrite = false;
                    three.MemtoReg = false;
                    three.IorD = true;
                    three.IRWrite = false;
                    three.PCWrite = false;
                    three.ALUOp = 0;
                    three.ALUSrcB = 2;
                    three.PCSource = 0;
                    return three;
                }
                //variable values for store word
                else if (Instruct.funct == "SW") {
                    State five = new State();
                    five.RegDst = false;
                    five.RegWrite = false;
                    five.ALUSrcA = true;
                    five.MemRead = false;
                    five.MemWrite = true;
                    five.MemtoReg = false;
                    five.IorD = true;
                    five.IRWrite = false;
                    five.PCWrite = false;
                    five.ALUOp = 0;
                    five.ALUSrcB = 2;
                    five.PCSource = 0;
                    return five;
                }
            } else if (Instruct.opCode == "R") {
                if (Instruct.funct == "") {
                    State seven = new State();
                    seven.RegDst = false;
                    seven.RegWrite = false;
                    seven.ALUSrcA = true;
                    seven.MemRead = false;
                    seven.MemWrite = true;
                    seven.MemtoReg = false;
                    seven.IorD = true;
                    seven.IRWrite = false;
                    seven.PCWrite = false;
                    seven.ALUOp = 0;
                    seven.ALUSrcB = 2;
                    seven.PCSource = 0;
                    return seven;
                }
            } else if (Instruct.opCode == "I") {
                if (Instruct.functI == "") {
                    State ten = new State();
                    ten.RegDst = false;
                    ten.RegWrite = false;
                    ten.ALUSrcA = true;
                    ten.MemRead = false;
                    ten.MemWrite = true;
                    ten.MemtoReg = false;
                    ten.IorD = true;
                    ten.IRWrite = false;
                    ten.PCWrite = false;
                    ten.ALUOp = 0;
                    ten.ALUSrcB = 2;
                    ten.PCSource = 0;
                    return ten;
                }
            }
            cycle++;

        } else if (cycle == 5) {
            State four = new State();
            four.RegDst = false;
            four.RegWrite = false;
            four.ALUSrcA = true;
            four.MemRead = false;
            four.MemWrite = true;
            four.MemtoReg = false;
            four.IorD = true;
            four.IRWrite = false;
            four.PCWrite = false;
            four.ALUOp = 0;
            four.ALUSrcB = 2;
            four.PCSource = 0;
            return four;
        }
    }

}
