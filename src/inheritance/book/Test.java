package inheritance.book;

import polymorphism.Man;

public class Test {
    public static void main(String[] args) {
        /*testReadPrivateParam();
        testConstructor();
        testOverride();
        testArray();*/
        testCast();
    }
    public static void testReadPrivateParam(){
        Manager manager = new Manager();
        manager.setSalary(100.0);
        manager.setBonus(10.0);
        System.out.println(manager.getSalary());
    }
    public static void testConstructor(){
        Manager manager = new Manager(100.0);
        manager.setBonus(10.0);
        System.out.println(manager.getSalary());
    }
    public static void testOverride(){
        Employee e = new Manager();
        e.show();
    }
    public static void testArray(){
        Employee[] es = new Employee[2];
        es[0] = new Manager(0.0);
        es[1] = new Employee(1.0);
        for (Employee e : es) {
            System.out.println(e.getSalary());
            e.show();
        }
    }
    public static void testCast(){
        Manager[] ms = new Manager[1];
        ms[0] = new Manager();
        Employee e = ms[0];
        e.show();

        Employee[] es = new Manager[2];
        es[1] = new Manager();
        if( es[1] instanceof Manager){
            Manager m = (Manager) es[1];
            m.show();
        }else{
            System.out.println("can't cast");
        }
    }
}
