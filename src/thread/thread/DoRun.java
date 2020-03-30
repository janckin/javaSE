package thread.thread;

public class DoRun implements Runnable {
    private Thread thread;
    private String threadName;

    public DoRun(String name) {
        this.threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Ready Running " + threadName);
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Running Thread: " + threadName + ",yeeeeeeeh!>>>>>>>>>>>>>" + i);
                Thread.sleep(50);
                System.out.println("Running Thread: " + threadName + "," + i + ">>>finish!");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Finish Thread " + threadName);
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

}
