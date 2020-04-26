package thread.executor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

public class MatchCounter implements Callable<Integer> {
    private String keyword;
    private File root;
    private ExecutorService executor;

    public MatchCounter(String directory, String keyword, ExecutorService executor) throws RuntimeException {
        this.keyword = keyword;
        this.root = new File(directory);
        if (!root.exists()) {
            throw new RuntimeException("directory is wrong");
        }
        this.executor = executor;
    }

    public boolean search(File file) throws IOException {
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String context;
            while ((context = bf.readLine()) != null) {
                if (context.contains(this.keyword)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Integer call() throws Exception {
        int count = 0;
        File[] files = root.listFiles();
        if (Objects.isNull(files)) {
            return count;
        }
        List<Future<Integer>> results = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                MatchCounter matchCounter = new MatchCounter(file.getAbsolutePath(), keyword, executor);
                Future<Integer> future = executor.submit(matchCounter);
                results.add(future);
            } else {
                if (search(file)) count++;
            }
        }
        for (Future<Integer> result : results) {
            count = count + result.get();
        }
        return count;
    }
}
