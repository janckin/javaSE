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

        //通用动态代理
        try {
            System.out.println("------------");
            CommonProxy commonProxy = new CommonProxy(car);
            Machine commonProxyCar2 = (Machine) commonProxy.getInstance();
            commonProxyCar2.brand();

            System.out.println("------------");
            Car commonProxyCar = (Car) commonProxy.getInstance();//这样会报错
            commonProxyCar.brand();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
