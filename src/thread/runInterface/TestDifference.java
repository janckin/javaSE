package thread.runInterface;

public class TestDifference {

    public static void main(String[] args) {
        testThreadExtend();
        testRunnable();
    }

    public static void testThreadExtend() {
        PrintThread th1 = new PrintThread("pth1", "run pth1!");
        PrintThread th2 = new PrintThread("pth2", "run pth2!");
        PrintThread th3 = new PrintThread("pth3", "run pth3!");
        th1.start();
        th2.start();
        th3.start();
    }

    public static void testRunnable() {
        Runnable r1 = () -> System.out.println("run r1");
        Runnable r2 = () -> System.out.println("run r2");
        Runnable r3 = () -> System.out.println("run r3");
        new Thread(r1, "r1").start();
        new Thread(r2, "r2").start();
        new Thread(r3, "r3").start();
    }
}
