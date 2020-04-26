package thread.forkJoin;

import java.security.InvalidParameterException;
import java.util.concurrent.RecursiveTask;


public class Counter extends RecursiveTask<Integer> {
    private int start;
    private int end;
    private int[] arr;

    public Counter(int start, int end, int[] arr) {
        this.start = start;
        this.end = end;
        if (end < start) {
            throw new InvalidParameterException("start larger than end");
        }
        this.arr = arr;
        if (end >= arr.length) {
            this.end = arr.length - 1;
        }
    }

    @Override
    protected Integer compute() {
        if (end - start == 1) {
            return arr[start] + arr[end];
        } else if (end - start == 0) {
            return arr[start];
        } else {
            int mid = (end + start) / 2;/* key: to get the middle index*/
            Counter first = new Counter(start, mid, arr);
            Counter second = new Counter(mid + 1, end, arr);
            invokeAll(first, second);
            return first.join() + second.join();
        }
    }
}
