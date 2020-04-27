package testStream.commonTypeStream;

import dataStructures.princeton.sort.SortUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DifferenceTest {
    public static void main(String[] args) {
        useObjectStreamSum();
        useIntStreamSum();
    }

    public static void useObjectStreamSum() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.stream().reduce(Integer::sum).orElse(0));
    }

    public static void useIntStreamSum() {
        IntStream intStream = IntStream.of(0, 1, 2, 3, 4);
        System.out.println(intStream.sum());
    }

}
