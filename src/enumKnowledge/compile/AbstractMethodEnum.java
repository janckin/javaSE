package enumKnowledge.compile;

public enum AbstractMethodEnum {
    SPRING(0) {
        @Override
        public String printValue() {
            return "SPRING printValue";
        }
    },
    SUMMER(1) {
        @Override
        public String printValue() {
            return "SUMMER printValue";
        }
    };

    public abstract String printValue();

    private int value;

    AbstractMethodEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
