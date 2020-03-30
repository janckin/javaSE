package proxyObject.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 *  1. 此类在Car类型Machine接口调用的每一个方法前后，增加一段文字
 *  2. 在s使用car类是启动brand方法前再加入一段文字
 */
public class MachineProxy {

    private Machine target;
    public MachineProxy(Machine target){
        this.target = target;
    }

    public Machine getMachine() {
        return (Machine) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            //执行所有方法前插入的操作
            System.out.println("------before all methods will run-----");
            //执行brand方法后前插入操作
            if (method.getName().equals("brand") && target instanceof Car) {
                System.out.println("before car brand");
            }

            //执行方法
            Object o = method.invoke(target, args);

            //执行brand方法后再插入操作
            if (method.getName().equals("brand") && target instanceof Plane) {
                System.out.println("after plane brand");
            }
            return o;
        });
    }
}
