package testCollection.list;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

//special exception comes from remove
public class SpException {
    private static List<String> list;

    private static void renewList() {
        list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("forth");
        list.add("fifth");
        list.add("sixth");
    }

    @SuppressWarnings("all")
    public static void testForeachException() throws ConcurrentModificationException {
        renewList();
        int i = 1;
        for (String str : list) {
            System.out.println(i++);
            System.out.println(str);
            if (str.equals("forth")) {
                list.remove(str);//exception, but method still work while loop never run to next
            }
        }
    }

    @SuppressWarnings("all")
    public static void testForeachExceptionEquality() throws ConcurrentModificationException {
        renewList();
        int i = 1;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(i++);
            System.out.println(str);
            if (str.equals("forth")) {
                list.remove(str);//exception, but method still work while loop run to next
            }
        }
    }

    @SuppressWarnings("all")
    public static void testItException() throws ConcurrentModificationException {
        renewList();
        int i = 1;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(i++);
            String str = it.next();
            System.out.println(str);
            if (str.equals("forth")) {
                list.remove(str);//exception, but method still work while loop run to next
            }
        }
    }

    @SuppressWarnings("all")
    public static void testConcurrent() {
        renewList();
        list.removeIf(str -> str.equals("forth"));//run normally
    }

    public static void main(String[] args) {
        try {
            System.out.println(">>>>>test ConcurrentModificationException>>>>>");
            testForeachException();
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        } finally {
            System.out.println(list.toString());
        }

        try {
            System.out.println(">>>>>test testForeachExceptionEquality>>>>>");
            testForeachExceptionEquality();
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        } finally {
            System.out.println(list.toString());
        }

        try {
            System.out.println(">>>>>test testItException>>>>>");
            testItException();
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        } finally {
            System.out.println(list.toString());
        }


        System.out.println(">>>>>test Concurrent>>>>>");
        testConcurrent();
        System.out.println(list.toString());
    }
}
