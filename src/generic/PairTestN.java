package generic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PairTestN {

    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Pair pair2 = new Pair("first","second");
        pair2.getFirst();

        DateInterval dateInterval = new DateInterval();
        Pair<LocalDate> pair = dateInterval;
        pair.setFirst(LocalDate.MIN);
        pair.setSecond(LocalDate.now());

        List<String> listStr = new ArrayList<>();
        List<Integer> listInt = new ArrayList<>();
        System.out.println(listStr.getClass() == listInt.getClass());

        Pair<String> pairs = Pair.init(String::new);
        Pair<String> pairs2 = Pair.initByReflect(String.class);


    }
}
