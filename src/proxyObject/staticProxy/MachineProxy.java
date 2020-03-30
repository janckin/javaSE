package proxyObject.staticProxy;


import java.lang.reflect.Proxy;

/**
 *  此类可以把所有实现Machine接口的类里面对应的方法加入描述
 *  问题：每次运行就需要运行MachineProxy，且必须传入实例化好一个类才行！
 */
public class MachineProxy implements Machine {
    private Machine machine;
    public MachineProxy(Machine car){
        System.out.println("here is static proxy");
        this.machine = car;
    }

    @Override
    public void brand() {
        System.out.println("here is before brand method");
        machine.brand();
    }

    @Override
    public void engine(String name) {
        System.out.println("here iis before engine method");
        machine.engine(name);
    }
}
