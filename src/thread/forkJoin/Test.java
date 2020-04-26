package thread.forkJoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            Random r = new Random();
            int len = r.nextInt(3000);
            while (len <= 0) {
                len = r.nextInt(3000);
            }
            int[] arr = new int[len];
            Random r2 = new Random(30);
            for (int j = 0; j < len; j++) {
                arr[i] = r2.nextInt();
            }
            Runnable run = () -> {
                //use stream
                int right = Arrays.stream(arr).sum();
                //use fork join
                Counter counter = new Counter(0, arr.length - 1, arr);
                ForkJoinPool pool = new ForkJoinPool();
                pool.invoke(counter);
                int result = counter.join();

                //compare result
                if (right == result) {
                    System.out.println("test pass!");
                } else {
                    System.out.println("test fail!");
                    System.out.println("stream : " + right);
                    System.out.println("fork-join : " + result);
                }
            };
            executorService.submit(run);
        }
    }
}
