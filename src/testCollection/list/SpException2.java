package testCollection.list;

import java.util.*;

public class SpException2 {
    public static void main(String[] args) {
        testItException2();
        testItException3();
    }

    @SuppressWarnings("all")
    public static void testItException2() throws ConcurrentModificationException {
        list = new LinkedList<>();
        list.add("sixth");
        int i = 1;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(i++);
            String str = it.next();
            System.out.println(str);
            if (str.equals("sixth")) {
                list.remove(str);//exception, but method still work while loop run to next
            }
        }
    }

    private static List<String> list;

    @SuppressWarnings("all")
    private static void testItException3() {
        list = new ArrayList<>();
        list.add("hello");
        int i = 1;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(i++);
            String str = it.next();
            System.out.println(str);
            if (str.equals("hello")) {
                list.remove(str);//exception, but method still work while loop run to next
            }
        }
    }
}
