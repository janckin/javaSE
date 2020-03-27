package proxyObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.Object;

interface Subject2 {
    public void run();

    public void hello();
}

class RealSubject2 implements Subject {

    @Override
    public void run() {
        // TODO Auto-generated method stub
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

class MyInvocationHandler2<T> implements InvocationHandler {
    private T obj;

    public MyInvocationHandler2(T obj) {
        this.obj = obj;
    }

    //获取被代理对象滴
    @SuppressWarnings("unchecked")
    public T blind() {
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object returnVal = (Object) method.invoke(obj, args);
        System.out.println("later");
        return returnVal;
    }

}

public class TestDynamicGenericity {

    public static void main(String[] args) {
    }

}
