package polymorphism;

public class Person {
    private String name;
    private int age;

    public void eat() {
        System.out.println("eat!");
    }

    public void walk() {
        System.out.println("walk!");
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

}
