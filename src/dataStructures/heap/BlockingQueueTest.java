package dataStructures.heap;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//this class will show the process of supplier and consumer
public class BlockingQueueTest {
    private static BlockingQueue<File> threadQueue = new LinkedBlockingQueue<>();
    private static File end = new File("");

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("write down directory(e.g. /opt/jdk1.8.0/src): ");
            String directory = sc.next();
            System.out.println("entry the keyword of search : ");
            String keyword = sc.next();

            Runnable consumerRunnable = () -> {
                try {
                    File file = new File(directory);
                    addFile(file);
                    threadQueue.add(end);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    System.out.println("the directory is error");
                }
            };

            new Thread(consumerRunnable, "consumer").start();

            int SUPPLIERS_THREAD_NUM = 100;
            for (int i = 0; i < SUPPLIERS_THREAD_NUM; i++) {
                Runnable supplierRun = () -> {
                    try {
                        boolean done = false;
                        while (!done) {
                            File file = threadQueue.take();
                            if (file == end) {
                                threadQueue.put(end);
                                done = true;
                            } else {
                                searchKeyWord(file, keyword);
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                };
                new Thread(supplierRun, "supplierRun" + i).start();
            }

        }

    }

    /**
     * read all the file into queue
     * this process act as consumer
     *
     * @param file the root file
     */
    public static void addFile(File file) throws InterruptedException, FileNotFoundException {
        if (Objects.isNull(file)) throw new FileNotFoundException();
        File[] files = file.listFiles();
        if (Objects.isNull(files)) throw new FileNotFoundException();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                addFile(file1);
            } else {
                threadQueue.put(file1);
            }
        }
    }

    /**
     * find all the context contains keywords
     *
     * @param file    the target
     * @param keyword the keyword which client wants to search
     */
    public static void searchKeyWord(File file, String keyword) {
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            int lineNumber = 0;
            String context;
            while ((context = bf.readLine()) != null) {
                lineNumber++;
                if (context.contains(keyword)) {
                    System.out.printf("%s--%d--%s%n", file.getPath(), lineNumber, context);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
