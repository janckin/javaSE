package proxyObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Man {
    public void run();

    public void fly();
}

class SuperMan implements Man {

    @Override
    public void run() {
        System.out.println("I can run fast!");
    }

    @Override
    public void fly() {
        System.out.println("I can fly!");
    }
}

class HumanUtil {
    public static void title1() {
        System.out.println("======方法1========");
    }

    public static void title2() {
        System.out.println("======方法2========");
    }
}

class MyInvocationHandler3 implements InvocationHandler {
    private Object obj;

    public MyInvocationHandler3() {

    }

    public MyInvocationHandler3(Object obj) {
        this.obj = obj;
    }

    public void setObject(Object obj) {
        this.obj = obj;
    }

    public Object getNewInstance() {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("run")) {//只在run方法执行！
            HumanUtil.title1();
        }


        Object returnVal = (Object) method.invoke(obj, args);

        if (method.getName().equals("run")) {
            HumanUtil.title2();
        }

        return returnVal;
    }

}

class MyProxy {
    public static Object getProxyInterface(Object obj) {
        MyInvocationHandler3 myInvo = new MyInvocationHandler3(obj);
        return myInvo.getNewInstance();
    }
}

public class TestDynamicAOP {

    public static void main(String[] args) {
        Man man = (Man) MyProxy.getProxyInterface(new SuperMan());
        man.fly();
        man.run();
    }

}
