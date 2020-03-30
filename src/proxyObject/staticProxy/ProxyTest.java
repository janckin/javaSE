package proxyObject.staticProxy;

public class ProxyTest {
    public static void main(String[] args) {
        //使用代理前
        Machine beforeProxy = new Car();
        beforeProxy.brand();

        System.out.println("------------");

        //使用代理后
        Machine machineProxy = new MachineProxy(new Car());
        machineProxy.brand();

        //其他实现此接口的类
        System.out.println("------------");
        Machine planeProxy = new MachineProxy(new Plane());
        planeProxy.brand();
    }
}
