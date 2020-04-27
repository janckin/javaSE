package testStream;

import java.util.ArrayList;
import java.util.List;

public class Test {
    static List<String> words;

    public static void main(String[] args) {
        testFilter();
        testMap();
    }


    //test filter method
    public static void testFilter() {
        renew();
        //find the length less than 2
        words.stream().filter((word) -> word.length() <= 2).forEach(System.out::println);
    }

    //test map method
    public static void testMap() {
        renew();
        words.stream().map((word) -> word = word + "-created by me").forEach(System.out::println);
    }


    public static void renew() {
        words = new ArrayList<>();
        words.add("hello");
        words.add("world");
        words.add("!");
        words.add("here");
        words.add("is");
        words.add("tony");
        words.add("speaking");
    }


}
