package generic;

import java.util.Objects;

public class Parent {
    private String name;
    private int age;
    private long phone;

    public Parent() {

    }
    private Parent(long phone){
        this.phone = phone;
    }

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected Parent(String name, int age, long phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parent)) return false;
        Parent parent = (Parent) o;
        return age == parent.age &&
                phone == parent.phone &&
                Objects.equals(name, parent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, phone);
    }

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }

    public void testExtend(String hello){
        System.out.println("here is parent's set, param is "+ hello);
    }

    public static void printPair(Pair<? extends Parent> pair){
        System.out.println("print!");
    }

}
