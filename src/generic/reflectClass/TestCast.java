package generic.reflectClass;

import generic.Child;
import generic.Parent;

public class TestCast {
    public static void main(String[] args) {
        Child child = new Child();
        Class<Parent> clazz = Parent.class;
        Parent parent = clazz.cast(child);
        parent.testExtend("hello");
    }
}
