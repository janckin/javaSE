package thread;

//double checked lock
public class Singleton4 {
    private static Singleton4 instance = null;//1

    private Singleton4() {
    }

    ;

    public static Singleton4 getInstance() {
        if (instance == null) {//2
            instance = new Singleton4();//3
        }
        return instance;//4
    }
}
