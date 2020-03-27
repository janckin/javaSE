package setKnowledge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Testmain {

    public static void main(String[] args) {
        System.out.println(">>>>  setting >>>>>");
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < 20; i++) {
            set.add("hello << " + i);
        }
		/*Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String itContext = it.next();
			System.out.println(itContext);
		}*/

        System.out.println(">>>>   >>>>>");

        System.out.println(">>>> Collection >>>>>");
        Collection<String> col = new ArrayList<String>();
        col.addAll(set);
        Iterator<String> it_col = col.iterator();
        while (it_col.hasNext()) {
            String itContext = it_col.next();
            //System.out.println(itContext);
        }
        System.out.println(">>>> in set >>>>>");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String itContext = it.next();
            //System.out.println(itContext);
        }

        System.out.println(">>>> foreach lambda >>>>>");
        set.forEach(obj -> System.out.println(obj));
    }

}
