package testCollection.map;

import java.util.HashMap;
import java.util.Map;

public class TextGet {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("john", "hello john!");

        //test getOrDefault
        String str = map.get("ff");
        String str2 = map.getOrDefault("ff", "doesn't exist");

        System.out.println(str);
        System.out.println(str2);

        //test putIfAbsent
        map.putIfAbsent("john", "ff hello!");
        System.out.println(map.get("john"));
    }
}
