package thread.myconcurrent;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestIncrement {
    public static void incrementInMerge(){
        Map<String,Long> map = new ConcurrentHashMap<>();
        map.merge("hello", 1L, Long::sum);
    }
}
