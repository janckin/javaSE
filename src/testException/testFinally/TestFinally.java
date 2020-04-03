package testException.testFinally;

public class TestFinally {

    public static void main(String[] args) {
        //standardFinally();
        noExceptionInTry();
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
            System.out.println("here in finally!");
            return 3;
        }
    }

    public static void standardFinally(){
        try {
            System.out.println("here is try");
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("here is catch");
            e.printStackTrace();
            throw e;
        } finally {
            System.out.println("here is finally");
        }
    }

    public static void noExceptionInTry(){
        try {
            System.out.println("here is try");
        } catch (IllegalArgumentException e) {
            System.out.println("here is catch");
            e.printStackTrace();
            throw e;
        } finally {
            System.out.println("here is finally");
        }
        System.out.println("after try block");
    }
}
