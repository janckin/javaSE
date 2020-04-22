package thread.runInterface;

public class PrintThread extends Thread {

    private String title;

    public PrintThread(String name, String title) {
        super(name);
        this.title = title;
    }

    @Override
    public void run() {
        System.out.println(title);
    }
}
