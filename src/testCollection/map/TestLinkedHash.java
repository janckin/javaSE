package testCollection.map;

import java.util.LinkedHashMap;

public class TestLinkedHash {
    private static LinkedHashMap<Integer, String> linkedHashMap;

    private static void renew() {
        linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(9, "9s");
        linkedHashMap.put(2, "2s");
        linkedHashMap.put(3, "3s");
        linkedHashMap.put(4, "5s");
        linkedHashMap.put(7, "7s");
    }

    public static void main(String[] args) {
        //testOrder();
        testOrderAfterPutOrRead();
    }

    public static void testOrder() {
        renew();
        readKeyAndValue();
    }

    public static void testOrderAfterPutOrRead() {
        renew();
        linkedHashMap.put(1000, "1000s");
        System.out.println(linkedHashMap.get(3));
        readKeyAndValue();
    }

    private static void readKeyAndValue() {
        linkedHashMap.keySet().forEach(System.out::println);
        System.out.println(">>> value >>>>");
        linkedHashMap.values().forEach(System.out::println);
    }


}
