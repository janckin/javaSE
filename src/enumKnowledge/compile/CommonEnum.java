package enumKnowledge.compile;

public enum CommonEnum {
    AUTUMN(3), WINTER(4);
    private int value;

    CommonEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
