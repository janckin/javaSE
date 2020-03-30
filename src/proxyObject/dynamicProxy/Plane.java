package proxyObject.dynamicProxy;

public class Plane implements Machine {
    @Override
    public void brand() {
        System.out.println("here brand in plane");
    }

    @Override
    public void engine(String name) {
        System.out.println("here engine in plane:"+name);
    }
}
