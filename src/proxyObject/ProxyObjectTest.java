package proxyObject;

public class ProxyObjectTest {
    public void test() {
        Object3 obj = new ProxyObject();
        obj.action();
    }
}

interface Object3 {
    void action();
}

class ProxyObject implements Object3 {
    Object3 obj;

    //代理类的建立
    ProxyObject() {
        System.out.println("ProxyObject is created!");
        obj = new ObjectImpl();
    }

    //调用将要代理的方法
    @Override
    public void action() {
        // TODO Auto-generated method stub
        System.out.println("ProxyObject action method started");
        obj.action();
        System.out.println("ProxyObject action method end");
    }

}

class ObjectImpl implements Object3 {

    @Override
    public void action() {
        // TODO Auto-generated method stub
        System.out.println("ObjectImpl action start!");
        System.out.println("Object action function done");
        System.out.println("ObjectImpl action end!");
    }

}