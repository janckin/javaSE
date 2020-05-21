package dataStructures.pattern;

/*
 * 单例模式：就是整个程序都只有一个实例
 */
public class Singleton {
    public static void main(String[] args) {
        Singleone s1 = Singleone.getInstance();
        Singleone s2 = Singleone.getInstance();
        System.out.println(s1 == s2);
    }
}

// 饿汉式
class Singleone {
    //先封装好
    private Singleone() {

    }

    //内部进行实例化
    private static Singleone slo = new Singleone();

    public static Singleone getInstance() {
        return slo;
    }
}

//懒汉式:存在线程安全问题
class SingleTwo {
    //先封装好
    private SingleTwo() {

    }

    //内部进行实例化
    private static SingleTwo slt = null;

    public static SingleTwo getInstance() {
        if (slt == null) {
            //如果第一个路径在此停止，第二个进程可以进入！！
            slt = new SingleTwo();
        }
        return slt;
    }
}
