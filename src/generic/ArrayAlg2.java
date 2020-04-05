package generic;

import java.time.LocalDate;
import java.util.ArrayList;

//this class to improve ArrayAlg in PairTest1
public class ArrayAlg2 {

    public static <T extends Comparable<T>> T min(T[] a) {
        T min = a[0];
        for (T t : a) {
            if (t.compareTo(min) < 0) min = t;
        }
        return min;
    }

    public static <T extends Comparable<? super T>> T improveMin(T[] a) {
        T min = a[0];
        for (T t : a) {
            if (t.compareTo(min) < 0) min = t;
        }
        return min;
    }

    public static void main(String[] args) {
        LocalDate[] a = {LocalDate.MIN, LocalDate.MAX, LocalDate.now()};
        System.out.println(ArrayAlg2.min(a));
        System.out.println(ArrayAlg2.improveMin(a));
    }
}
