package polymorphism;

public class TestPerson {
    public static void main(String[] args) {
        Person p = new Man();
        // p.pay() 不能使用

        if (p instanceof Man) {
            ((Man) p).pay();
        }
        if (p instanceof Woman) {
            ((Woman) p).shopping();
        }
        p.equals(p);
    }
}
