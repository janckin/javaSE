package reflectClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class TestReflect {

    public static void main(String[] args) {
        String className = "com.atguigu.thread.Clerk";
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Class<?> upCl = clazz.getSuperclass();
        //System.out.println(Modifier.toString(clazz.getModifiers()));//獲取修飾符
        //printConstructor(clazz);

        //调用方法
        try {
            Method ms = clazz.getMethod("getProduct", null);//名字 和 参数的类型
            try {
                int i = (int) ms.invoke(clazz.newInstance(), 20);
                System.out.println(i);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public static void printConstructor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getConstructors();//获取所有构造器
        for (Constructor<?> c : constructors) {
            System.out.println("获取参数数量为");
            System.out.println(c.getParameterCount());//获取构造器参数数量的
            System.out.println("的构造器");


            System.out.println("获取权限修饰符>>>>>>>>" + Modifier.toString(c.getModifiers()));

            System.out.println("获取参数类型>>>>>>>>>>>");
            Class<?>[] paramsClass = c.getParameterTypes();//获取构造器参数类型
            for (Class<?> paraClass : paramsClass) {
                System.out.println("simpleName : " + paraClass.getSimpleName());//string
                System.out.println("getname : " + paraClass.getName());//java.lang.String 整个包的
            }
        }
    }


}
