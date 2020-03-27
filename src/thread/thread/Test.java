package thread.thread;

public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DoRun R1 = new DoRun("John");
        R1.start();

        DoRun R2 = new DoRun("Ben");
        R2.start();
    }

}
