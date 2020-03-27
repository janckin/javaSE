package enumKnowledge;

public enum Season {
    /*Season() {
        public static final String SPRING="春天";
        public static final String SUMMER="夏天";
        public static final String AUTUMON="秋天";
        public static final String WINTER="冬天";
    }*/
    //SPRING = "春天",SUMMER="夏天",AUTUMON="秋天",WINTER="冬天";
    SPRING("春天"), SUMMER("夏天"), AUTUMON("秋天"), WINTER("冬天");

    private String name;

    Season(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }

}
