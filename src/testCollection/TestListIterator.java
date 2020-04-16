package testCollection;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestListIterator {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        testRemove(list);
        testIndexAndNext(list);
        testIndexAndPrevious(list);
    }

    public static void testRemove(List<Integer> list) {
        System.out.println(">>>>>> testRemove >>>>>>");
        renewList(list);
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            int element = it.next();
            if (element == 3) {
                it.set(777);
                System.out.println("replace !");
            }
        }

        list.forEach(System.out::println);
    }

    public static void testIndexAndNext(List<Integer> list) {
        System.out.println(">>>>>> testIndexAndNext >>>>>>");
        renewList(list);
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            System.out.println("real index is: " + it.nextIndex());
            int element = it.next();
            System.out.println("element is " + element + ", index after next() is: " + it.nextIndex());
        }
    }

    public static void testIndexAndPrevious(List<Integer> list) {
        System.out.println(">>>>>> testIndexAndPrevious >>>>>>");
        renewList(list);
        ListIterator<Integer> last = list.listIterator(list.size() - 1);

        while (last.hasPrevious()) {
            System.out.println("real index is: " + last.previousIndex());
            int element = last.previous();
            System.out.println("element is " + element + ", index after next() is: " + last.previousIndex());
        }
    }

    private static void renewList(List<Integer> list) {
        if (!list.isEmpty()) list.clear();
        for (int i = 0; i < 7; i++) {
            list.add(i);
        }
    }
}
