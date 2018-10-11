package section6;

public enum  BasicOperation implements Operation{
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x+y;
        }
    },
    MINUS("-"){
        @Override
        public double apply(double x, double y) {
            return x-y;
        }
    },
    TIMES("*"){
        @Override
        public double apply(double x, double y) {
            return x*y;
        }
    },
    DIVIDE("/"){
        @Override
        public double apply(double x, double y) {
            return x/y;
        }
    };

    private final String symbol;
    BasicOperation(String s) {
        this.symbol=s;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
