package generic.reflectClass;

import generic.Parent;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TestReflect {

    public static void main(String[] args) {
        String className = "generic.Parent";
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        assert clazz != null;
        useMethodInvoke(clazz);
        useConstructor(clazz);
    }

    public static void useMethodInvoke(Class<?> clazz){
        try {
            assert clazz != null;//test clazz
            Parent parent = (Parent) clazz.newInstance();
            Method ms = clazz.getMethod("setName", String.class);//名字 和 参数的类型
            ms.invoke(parent, "john");
            System.out.println("use invoke: "+parent.toString());
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void useConstructor(Class<?> clazz){
        try {
            assert clazz != null;//test clazz
            Constructor<?> constructor = clazz.getConstructor(String.class,int.class);
            Parent parent = (Parent)constructor.newInstance("tony",32);
            System.out.println("use constructor: "+parent.toString());
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
