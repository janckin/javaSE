package enumKnowledge.compile;

public class Test {
    public static void main(String[] args) {
        testAbstractMethodEnum();
        testCommonEnum();
    }

    public static void testAbstractMethodEnum() {
        System.out.println(AbstractMethodEnum.SPRING.printValue());
        System.out.println(AbstractMethodEnum.SUMMER.printValue());
        System.out.println(AbstractMethodEnum.SPRING.getValue());
        System.out.println(AbstractMethodEnum.SUMMER.getValue());
    }

    public static void testCommonEnum() {
        System.out.println(CommonEnum.AUTUMN.getValue());
        System.out.println(CommonEnum.WINTER.getValue());
    }
}
