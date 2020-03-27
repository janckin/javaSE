package abstractClass;

public class Worker extends People {
    //必须要重写所有抽象类
    @Override
    public void eat() {
        System.out.println("eat");
    }

    @Override
    public void walk() {
        System.out.println("walk");
    }

    public Worker() {
        super();
    }

    public Worker(int i) {
        super(i);
    }
}