package other.AboutSwitch;

import java.util.Objects;
import java.util.Random;

public class AboutSwitch {
    public static void main(String[] args) {
        /*testSwitch();
        testSwitch2();
        testNoBreakInCase();*/
        testEnumCase();
    }

    public static void testSwitch() {
        Random r = new Random();
        int index = r.nextInt(4);
        switch (index) {
            case 0:
                System.out.println("case 0, index is " + index);
                break;
            case 1:
                System.out.println("case 1, index is " + index);
                break;
            case 2:
                System.out.println("case 2 , index is " + index);
                break;
            default:
                System.out.println("nothing");
        }
    }

    public static void testSwitch2() {
        Random r = new Random();
        int index = r.nextInt(5);
        switch (index) {
            case 0 -> System.out.println("case 0, index is " + index);
            case 1 -> System.out.println("case 1, index is " + index);
            case 2 -> System.out.println("case 2 , index is " + index);
            default -> System.out.println("nothing");
        }
    }
    public static void testNoBreakInCase(){
        int index = 0;
        switch (index) {
            case 0:
                System.out.println("case 0, index is " + index);
            case 1:
                System.out.println("case 1, index is " + index);
            case 2:
                System.out.println("case 2 , index is " + index);
            default:
                System.out.println("nothing");
        }
    }
    public static void testEnumCase(){
        Season[] ss = Season.values();
        Season s = ss[Objects.checkIndex(new Random().nextInt(4), ss.length)];
        switch(s){
            case SPRING -> System.out.println("it is spring!" + Season.SPRING);
            case SUMMER -> System.out.println("it is summer!" + Season.SUMMER);
            case FAIL -> System.out.println("it is fail!" + Season.FAIL);
            case WINTER -> System.out.println("it is winter!" + Season.WINTER);
            default -> System.out.println("no season find");
        }
    }
}
