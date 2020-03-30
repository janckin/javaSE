package file;

import java.io.File;

public class FileMakeNewDisk {

    // 尝试新建目录
    public void createNewDisk() throws Exception {
        String pathname = "D:\\documentTest";
        File file = new File(pathname + File.separator + "hello.txt");
        File file_path = new File(pathname);
        try {
            // System.out.println(file_path.exists());//document is exist?
            // System.out.println(file_path.isDirectory()); is a document?
            if (file_path.exists()) {
                System.out.println("document is exist");
            } else {
                file_path.mkdir();
            }
            if (file.exists()) {
                System.out.print("file is exists");
            } else {
                file.createNewFile();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(">>execute error");
            file_path.delete();
        }

    }

    public int add(int a, int b) {
        return a + b;
    }

    public int substract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a / b;
    }
}
