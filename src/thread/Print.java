package thread;

public class Print {
    public static void printContent(String threadName) {
        for (int i = 1; i <= 10000; i++) {
            System.out.println(threadName + " ===== " + i);
        }
    }
}
