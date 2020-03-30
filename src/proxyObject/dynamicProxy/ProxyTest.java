package proxyObject.dynamicProxy;

public class ProxyTest {
    public static void main(String[] args) {
        //使用代理前
        Machine car = new Car();
        car.brand();

        System.out.println("------------");

        //使用代理后
        MachineProxy proxy = new MachineProxy(car);
        Machine newCar = proxy.getMachine();
        newCar.brand();

        //其他实现此接口的类
        System.out.println("------------");
        MachineProxy proxy2 = new MachineProxy(car);
        Machine plane = proxy.getMachine();
        plane.brand();
    }
}
