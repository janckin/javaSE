package thread;

public class PrintThread extends Thread {
    public void run() {
        Print.printContent(Thread.currentThread().getName());
    }
}
