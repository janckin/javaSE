package testFinally;

public class TestFinally {

    public static void main(String[] args) {
        int i = method();
        System.out.println(i);
    }

    public static int method() {
        try {
            //if exist finally, It will never return 1 or 2 whatever it comes to exception

            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            //finally means always run
            System.err.println("here in finally!");
            return 3;
        }
    }
}
