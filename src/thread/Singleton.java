package thread;

//double checked lock
public class Singleton {
    private static Singleton instance = null;//1

    private Singleton() {
    }

    ;

    public static Singleton getInstance() {
        if (instance == null) {//2
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();//3
                }
            }
        }
        return instance;//4
    }
}
