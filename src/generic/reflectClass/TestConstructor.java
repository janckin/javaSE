package generic.reflectClass;

import generic.Child;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class TestConstructor {
    public static void printPublicConstructor(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getConstructors();//获取public 构造器
        print(constructors);
    }
    public static void printDeclaredConstructors(Class<?> clazz){
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();//获取所有构造器
        print(constructors);
    }
    private static void print(Constructor<?>[] constructors){
        for (Constructor<?> c : constructors) {
            System.out.println("--------------------------");
            System.out.println("the name of constructor:" + c.getName());
            System.out.println("totally:" + c.getParameterCount() + " parameters");

            System.out.println("the key word of constructor : " + Modifier.toString(c.getModifiers()));

            System.out.println(">>>>>> get the parameters' type >>>>>>>>>>>");
            Class<?>[] paramsClass = c.getParameterTypes();//获取构造器参数类型
            for (Class<?> paraClass : paramsClass) {
                System.out.println("parameter type : " + paraClass.getSimpleName());//String
                System.out.println("parameter truly type : " + paraClass.getName());//java.lang.String 整个包的
            }
        }
    }

    public static void main(String[] args) {
        Class<?> upCl = Child.class.getSuperclass();
        printPublicConstructor(upCl);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        printDeclaredConstructors(upCl);
    }
}
