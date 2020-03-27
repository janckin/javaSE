package list;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestUnit {

    public TestUnit() {
        // TODO Auto-generated constructor stub
    }

    //@Test
    public void testLinkList() {

        Object[] objects = new Object[26];
        char a = 'a';
        int j = (int) a;
        for (int i = 0; i < 26; i++) {
            objects[i] = (char) (j + i);
        }
        MyListedList linkList = new MyListedList(objects);
        System.out.println(linkList.size);
        System.out.println(linkList.toString());
        Object t1 = 'c';
        Object t2 = 'C';
        Object t3 = 'a';
        System.out.println(linkList.indexOf(t1));
        System.out.println(linkList.indexOf(t2));
        System.out.println(linkList.indexOf(t3));
    }

    @Test
    public void testSqListClear() {
        SqList sqList = new SqList(26);
        char a = 'a';
        int j = (int) a;
        for (int i = 0; i < 26; i++) {
            //System.out.println("插入i>>>"+i);
            sqList.insert(i, (char) (j + i));
        }
        //sqList.display();
        sqList.clear();
        System.out.println(sqList.get(0));
    }

    @Test
    public void testConcurrentModException() {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("forth");
        list.add("fifth");
        list.add("sixth");
        //int i = 1;
        /*for (String str : list) {
            System.out.println(i++);
            if (str.equals("forth")) {
                list.remove(str);
            }
        }*/
        /*Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(i++);
            String str = it.next();
            System.out.println(str);
            if (str.equals("fifth")) {
                list.remove(str);
            }
        }*/
        list.removeIf(str -> str.equals("fifth"));
    }

}
