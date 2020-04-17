package testCollection.map;

import java.util.Arrays;
import java.util.List;

public class TestArraysToList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 4, 5, 6);
        list.add(7);
        list.forEach(System.out::println);
    }
}
