package testCollection;

import java.util.*;

@SuppressWarnings("all")
public class TestIterator {

    public static void testLinkListIterator() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int element = it.next();
            if (element == 4) {
                it.remove();
            }
        }
        System.out.println("the remain element");
        list.forEach(System.out::println);
    }

    public static void testArrayListIterator() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int element = it.next();
            if (element == 4) {
                it.remove();//exception
            }
        }
        System.out.println("the remain element");
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        testLinkListIterator();
        testArrayListIterator();
    }
}
