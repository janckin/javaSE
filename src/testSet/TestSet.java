package testSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Comparator<Person> comparetor = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                // TODO Auto-generated method stub
                Person p1 = (Person) o1;
                Person p2 = (Person) o2;
                if (p1.getId() != p2.getId()) {
                    return p1.getId() - p2.getId();
                }
                if (!p1.getName().equals(p2.getName())) {
                    return p1.getName().compareTo(p2.getName());
                }
                return p1.getClassroom().compareTo(p2.getClassroom());
                //return p1.getId() - p2.getId();
            }

        };
        //根据上述的定制可以定义说明内容为不一致
        TreeSet<Person> ts1 = new TreeSet<Person>(comparetor);
        ts1.add(new Person(2, "john7", "a"));
        ts1.add(new Person(3, "john2", "a"));
        ts1.add(new Person(1, "john1", "h"));
        ts1.add(new Person(2, "john", "a"));
        ts1.add(new Person(3, "john5", "a"));

		/*Iterator it1 = ts1.iterator();
		while(it1.hasNext()) {
			System.out.println(it1.next().toString());
		}*/

        //类内部重写了comparable
        TreeSet<Car> ts2 = new TreeSet<Car>();
        ts2.add(new Car("Fe3ee", "bens"));
        ts2.add(new Car("Fe3ee", "broch"));
        ts2.add(new Car("Fe4ee", "audio"));
        ts2.add(new Car("Fe9ee", "bens"));
        ts2.add(new Car("Fe0ee", "bens"));

        Iterator<Car> it2 = ts2.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next().toString());
        }

        List<Car> list2 = new ArrayList<>();
        list2.add(new Car("Fe3ee", "bens"));
        list2.add(new Car("Fe3ee", "broch"));
        list2.add(new Car("Fe4ee", "audio"));
        list2.add(new Car("Fe9ee", "bens"));
        list2.add(new Car("Fe0ee", "bens"));

        Map<Integer, Car> map = new HashMap<>();
        for (int i = 0; i < list2.size(); i++) {
            map.put(i, list2.get(i));
        }
        Set<Map.Entry<Integer, Car>> set = map.entrySet();
        Iterator<Map.Entry<Integer, Car>> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getKey());
            System.out.println(it.next().getValue());
        }
    }

}
