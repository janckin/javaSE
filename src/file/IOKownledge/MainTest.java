package file.IOKownledge;

import java.io.FileInputStream;
import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        //inputstream
        FileInputStream fileInputStream = new FileInputStream("D:\\hello.txt");
        byte[] bytes = new byte[1024];
        int readnum = 0;
        while ((readnum = fileInputStream.read(bytes)) > 0) {
            System.out.println(new String(bytes, 0, readnum));
        }
        fileInputStream.close();
    }
}
