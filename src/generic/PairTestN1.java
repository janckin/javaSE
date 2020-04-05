package generic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PairTestN1 {

    public static void main(String[] args) {
        //test extends
        Parent dateInterval1 = new Child();
        dateInterval1.testExtend("hello");

        Pair<Child> childPair = new Pair<>();
        Pair<Child2> child2Pair = new Pair<>();
        Parent.printPair(childPair);
        Parent.printPair(child2Pair);
    }
}
