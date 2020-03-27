package thread;

//inter static class
public class Singleton2 {
    private static class SingletonProxy {
        private static final Singleton2 instance = new Singleton2();
    }

    private Singleton2() {
    }

    ;

    public static Singleton2 getInstance() {
        return SingletonProxy.instance;
    }
}
