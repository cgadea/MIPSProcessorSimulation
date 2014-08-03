package stuff;

public enum ProcessorState {

    ZERO {
        @Override
        public ProcessorState nextState(){
            System.out.print("");
            return ONE;
        }
    },
    ONE {
        @Override
        public ProcessorState nextState(){
            System.out.print("");
            return TWO;
        }
    },
    TWO {
        @Override
        public ProcessorState nextState(){
            System.out.print("");
            return THREE;
        }
    },
    THREE {
        @Override
        public ProcessorState nextState(){
            System.out.print("");
            return FOUR;
        }
    },
    FOUR {
        @Override
        public ProcessorState nextState(){
            System.out.print("");
            return FIVE;
        }
    },
    FIVE {
        @Override
        public ProcessorState nextState(){
            System.out.print("");
            return SIX;
        }
    },
    SIX {
        @Override
        public ProcessorState nextState(){
            System.out.print("");
            return SEVEN;
        }
    },
    SEVEN {
        @Override
        public ProcessorState nextState(){
            System.out.print("");
            return EIGHT;
        }
    },
    EIGHT {
        @Override
        public ProcessorState nextState(){
            System.out.print("");
            return NINE;
        }
    },
    NINE {
        @Override
        public ProcessorState nextState(){
            System.out.print("");
            return TEN;
        }
    },
    TEN {
        @Override
        public ProcessorState nextState(){
            System.out.print("");
            return ZERO;
        }
    };

    public abstract ProcessorState nextState();

}
