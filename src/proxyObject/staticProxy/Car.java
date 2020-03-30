package proxyObject.staticProxy;

public class Car implements Machine {
    @Override
    public void brand() {
        System.out.println("here is brand method");
    }

    @Override
    public void engine(String name) {
        System.out.println("here is engine method, engine's name" + name);
    }
}
