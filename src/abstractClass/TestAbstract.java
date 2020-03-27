package abstractClass;

public class TestAbstract {
    public static void main(String[] args) {
        People p = new Worker(33);
        System.out.println(p.getI());
        Worker w = new Worker(44);
        System.out.println(w.getI());
    }

}
