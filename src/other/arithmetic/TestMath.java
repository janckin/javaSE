package other.arithmetic;

import static java.lang.Math.*;

public class TestMath {
    public static void main(String[] args) {
        testModeLessThanZero();
        testSqrt();
    }

    public static void testModeLessThanZero(){
        double x1 = -18;
        double mod1 = x1 % 5;
        System.out.println(mod1);//-3.0

        double mod2 = x1 % 9;
        System.out.println(mod2);//-0.0

        double mod3 = x1 % (-5);
        System.out.println(mod3);//-3.0
    }

    public static void testSqrt(){
        System.out.println(sqrt(100));
    }

}
