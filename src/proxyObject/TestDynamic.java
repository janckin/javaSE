package proxyObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject {
    public void run();

    public void hello();
}

class RealSubject implements Subject {

    @Override
    public void run() {
        System.out.println("I'm the real one!");
    }

    @Override
    public void hello() {
        System.out.println("I'm hello!");
    }

    public void own() {
        System.out.println("I'm own without para!");
    }

    public void ownWithPara(String a) {
        System.out.println("I'm own with para: " + a);
    }

}

class MyInvocationHandler implements InvocationHandler {
    Object obj;

    //获取被代理对象滴
    public Object blind(Object obj) {
        this.obj = obj;
        return (Object) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object returnVal = (Object) method.invoke(obj, args);
        System.out.println("later");
        return returnVal;
    }

}

public class TestDynamic {

    public static void main(String[] args) {
        RealSubject real = new RealSubject();
        MyInvocationHandler inv = new MyInvocationHandler();
        Subject sub = (Subject) inv.blind((Object) real);
        sub.run();
        sub.hello();
        real.own();
        real.ownWithPara("yes!");
    }

}
