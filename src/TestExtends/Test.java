package TestExtends;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        testCommon();
        testAbstract();
        testChild2();
    }

    public static void testCommon() {
        Child child = new Child();
        child.test();
    }

    public static void testAbstract() {
        AbstractChild child = new AbstractChild();
        child.test();
    }

    public static void testChild2() {
        Parent p = new Child2();
        p.test();
    }
}
