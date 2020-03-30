package proxyObject.dynamicProxy;

public class Car implements Machine {
    @Override
    public void brand() {
        System.out.println("here is car's brand method");
    }

    @Override
    public void engine(String name) {
        System.out.println("here is car's engine method, engine's name" + name);
    }
}
