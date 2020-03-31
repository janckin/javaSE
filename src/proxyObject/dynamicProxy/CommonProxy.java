package proxyObject.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * 这个类用于设置通用的代理
 */
public class CommonProxy {
    private Object target;

    public CommonProxy(Object target) {
        this.target = target;
    }

    public Object getInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            System.out.println("before method!");
            Object o = method.invoke(target, args);
            System.out.println("after method!");
            return o;
        });
    }
}
