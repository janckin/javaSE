package thread.executor;

import java.util.Scanner;
import java.util.concurrent.*;

public class TestExecutor {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("write down directory(e.g. /opt/jdk1.8.0/src): ");
            String directory = sc.next();
            System.out.println("entry the keyword of search : ");
            String keyword = sc.next();

            ExecutorService executorService = Executors.newCachedThreadPool();

            MatchCounter counter = new MatchCounter(directory, keyword, executorService);
            Future<Integer> rs = executorService.submit(counter);

            System.out.println("the result is " + rs.get());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
