package testCollection.map;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestEntryAdd {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("john", "hello john!");
        map.put("tony", "hello tony!");
        map.put("steve", "hello steve!");

        try {
            for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
                if (stringStringEntry.getKey().equals("steve")) {
                    map.put("yeah", "hello yeah!");
                }
            }
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
        Set<Map.Entry<String, String>> set = map.entrySet();
        Map.Entry<String, String> entry = new Map.Entry<>() {
            private String key;
            private String value;

            @Override
            public String getKey() {
                return key;
            }

            @Override
            public String getValue() {
                return value;
            }

            @Override
            public String setValue(String value) {
                this.value = value;
                return value;
            }
        };

        set.add(entry);


    }
}
