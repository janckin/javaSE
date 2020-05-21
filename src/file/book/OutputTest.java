package file.book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class OutputTest {
    public static void main(String[] args) throws IOException {
        OutputContextToFile();
    }

    public static void OutputContextToFile() throws IOException {
        String path = "F:" + File.separator + "hello.txt";
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        try (PrintWriter pw = new PrintWriter(file, StandardCharsets.UTF_8)) {
            String name = "john";
            int age = 10;
            double salary = 152.36;
            pw.println(name);
            pw.println("in age :" + age);
            pw.println("has salary :" + salary);
        }
    }
}
