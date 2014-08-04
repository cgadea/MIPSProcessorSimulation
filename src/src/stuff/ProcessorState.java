package stuff;

public enum ProcessorState {

    ZERO {
        @Override
        public ControlSignalSetting getSetting(String fn) {
            return getSetting();
        }

        public ControlSignalSetting getSetting(){
            return new ControlSignalSetting(
                false,false,false,true,false,false,false,true,true,0,1,0
            );
        }

        @Override
        public ProcessorState nextState(Instruction instruction){
            return ONE;
        }
    },
    ONE {
        @Override
        public ControlSignalSetting getSetting(String fn) {
            return getSetting();
        }

        public ControlSignalSetting getSetting(){
            return new ControlSignalSetting(
                false,false,false,false,false,false,false,false,false,0,3,0
            );
        }

        @Override
        public ProcessorState nextState(Instruction instruction){
            System.out.print("");
            return TWO;
        }
    },
    TWO {
        @Override
        public ControlSignalSetting getSetting(String fn) {
            return getSetting();
        }

        public ControlSignalSetting getSetting(){
            return new ControlSignalSetting(
                false,false,true,false,false,false,false,false,false,0,2,0
            );
        }

        @Override
        public ProcessorState nextState(Instruction instruction){
            if (instruction.getFunctI().equals("LW")) {
                return THREE;
            } else {
                return FIVE;
            }
        }
    },
    THREE {
        @Override
        public ControlSignalSetting getSetting(String fn) {
            return getSetting();
        }

        public ControlSignalSetting getSetting(){
            return new ControlSignalSetting(
                false,false,false,true,false,false,true,false,false,0,2,0
            );
        }

        @Override
        public ProcessorState nextState(Instruction instruction){
            System.out.print("");
            return FOUR;
        }
    },
    FOUR {
        @Override
        public ControlSignalSetting getSetting(String fn) {
            return getSetting();
        }

        public ControlSignalSetting getSetting(){
            return new ControlSignalSetting(
                false,true,false,false,true,false,false,false,false,0,2,0
            );
        }

        @Override
        public ProcessorState nextState(Instruction instruction){
            System.out.print("");
            return ZERO;
        }
    },
    FIVE {
        @Override
        public ControlSignalSetting getSetting(String fn) {
            return getSetting();
        }

        public ControlSignalSetting getSetting(){
            return new ControlSignalSetting(
                false,false,false,false,true,false,true,false,false,0,2,0
            );
        }

        @Override
        public ProcessorState nextState(Instruction instruction){
            System.out.print("");
            return SIX;
        }
    },
    SIX {
        @Override
        public ControlSignalSetting getSetting(String fn){
            if (fn.equals("ADD")){
                return new ControlSignalSetting(false,false,true,false,false,false,false,false,false,0,0,0);
            } else if (fn.equals("SUB")){
                return new ControlSignalSetting(false,false,true,false,false,false,false,false,false,1,0,0);
            } else {
                return new ControlSignalSetting(false,false,true,false,false,false,false,false,false,2,0,0);
            }
        }

        @Override
        public ProcessorState nextState(Instruction instruction){
            System.out.print("");
            return SEVEN;
        }
    },
    SEVEN {
        @Override
        public ControlSignalSetting getSetting(String fn) {
            return getSetting();
        }

        public ControlSignalSetting getSetting(){
            return new ControlSignalSetting(
                true,true,false,false,false,false,false,false,false,0,2,0
            );
        }

        @Override
        public ProcessorState nextState(Instruction instruction){
            System.out.print("");
            return ZERO;
        }
    },
    EIGHT {
        @Override
        public ControlSignalSetting getSetting(String fn){
            if (fn.equals("BEQ") || fn.equals("BNE")){
                return new ControlSignalSetting(
                    false,false,true,false,false,false,false,false,false,0,0,1
                );
            } else if (fn.equals("ADDI")) {
                return new ControlSignalSetting(
                    false,false,true,false,false,false,false,false,false,0,2,1
                );
            } else {
                return new ControlSignalSetting(
                    false,false,false,false,false,false,false,false,false,2,2,1
                );
            }
        }

        @Override
        public ProcessorState nextState(Instruction instruction){
            System.out.print("");
            return TEN;
        }
    },
    NINE {
        @Override
        public ControlSignalSetting getSetting(String fn) {
            return getSetting();
        }

        public ControlSignalSetting getSetting(){
            return new ControlSignalSetting(
                false,false,false,false,false,false,false,false,true,0,3,2
            );
        }

        @Override
        public ProcessorState nextState(Instruction instruction){
            System.out.print("");
            return ZERO;
        }
    },
    TEN {
        @Override
        public ControlSignalSetting getSetting(String fn) {
            return getSetting();
        }

        public ControlSignalSetting getSetting(){
            return new ControlSignalSetting(
                false,true,false,false,true,false,false,false,false,0,0,0
            );
        }

        @Override
        public ProcessorState nextState(Instruction instruction){
            System.out.print("");
            return ZERO;
        }
    };

    public abstract ControlSignalSetting getSetting(String fn);

    public abstract ProcessorState nextState(Instruction instruction);

}
