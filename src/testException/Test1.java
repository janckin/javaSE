package testException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test1 {
    public void tryWithResource(String filename) throws IOException {
        try (InputStream in = new FileInputStream(filename)) {
            int b;
            while((b=in.read())!=-1){
                System.out.print(Character.toChars(b));
            }
        }
    }

    public void read(String filename) throws IOException{
        try {
            InputStream in = new FileInputStream(filename);
            int b;
            while((b=in.read())!=-1){
                System.out.print(Character.toChars(b));
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void outData(String filename){
        try {
            InputStream in = new FileInputStream(filename);
            int b;
            while((b=in.read())!=-1){
                System.out.print(Character.toChars(b));
            }
            in.close();
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Test1 t = new Test1();
        t.read("a.txt");
    }
}
