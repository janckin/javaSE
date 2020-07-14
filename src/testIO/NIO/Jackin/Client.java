package testIO.NIO.Jackin;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author qinzhen
 * @create 2020/5/30 22:39
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8083);
            while(true) {
                Scanner scanner = new Scanner(System.in);
                String s = scanner.nextLine();
                socket.getOutputStream().write(s.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
