package thread;


import org.junit.jupiter.api.Test;

public class TestThread {

    public void test() {
        PrintThread thread = new PrintThread();
        thread.setName("childThread");
        thread.start();

        for (int i = 1; i <= 50; i++) {
            System.out.println(Thread.currentThread().getName() + " ===== " + i);
            if (i % 10 == 0) {
                //thread.join();
            }
        }

    }

    @Test
    public void testImplRunnable() {
        Window win = new Window();

        Thread window1 = new Thread(win, "1号 ");
        Thread window2 = new Thread(win, "2号 ");
        Thread window3 = new Thread(win, "3号 ");

        window1.start();
        window2.start();
        window3.start();
    }

    public static void main(String[] args) {
//		for(long i=0;i<10000000;i++) {
//			new Thread() {
//				public void run() {
//					Singleton.getInstance();
//					System.out.println("1");
//				}
//			}.start();
//		}
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        System.out.println(s1 == s2);
    }

}
