package testIO.IOKownledge;

import java.io.FileInputStream;
import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        //oldInputStream();
        getURL();
    }

    public static void getURL() {
        System.out.println(System.getProperty("user.dir"));//C:\Users\lsy\coding\project\javaSE
        System.out.println(System.getProperty("java.class.path"));//C:\Users\lsy\coding\project\javaSE\out\production\javaSE
        System.out.println(System.getProperty("java.class.version"));//57.0
        System.out.println(System.getProperty("java.home"));//C:\Users\lsy\coding\java13
        System.out.println(System.getProperty("java.vendor"));//Oracle Corporation
        System.out.println(System.getProperty("java.vendor.url"));//https://java.oracle.com/
        System.out.println(System.getProperty("java.version"));//13.0.2
        System.out.println(System.getProperty("os.arch"));//amd64
        System.out.println(System.getProperty("os.name"));//Windows 10
        System.out.println(System.getProperty("user.home"));//C:\Users\lsy
        System.out.println(System.getProperty("user.name"));//lsy
        System.out.println(System.getProperty("path.separator"));//;
        System.out.println(System.getProperty("line.separator"));//;
    }

    public static void oldInputStream() throws IOException {
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
