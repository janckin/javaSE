package thread;

public class Window implements Runnable {
    int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " 窗口 获得第 " + ticket-- + " 张票");
            } else {
                break;
            }
        }
    }

}
