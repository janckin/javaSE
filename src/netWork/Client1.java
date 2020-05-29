package netWork;

import enumKnowledge.Season;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) {
        callServerSocket();
    }

    public static void callServerSocket() {
        int port = 8189;
        try (Socket s = new Socket("localhost", port);
             OutputStream sendingInfo = s.getOutputStream();
             InputStream in = s.getInputStream()) {

            //设置输出流，以此传递给服务端
            System.out.println("Client has been find Server!!!!!");
            String s1 = "here is client, could you hear me???";
            String s2 = "if you get that, return my a parameter!";
            String s3 = Season.AUTUMN.toString();
            String separator = System.getProperty("line.separator");

            sendingInfo.write(s1.getBytes());
            sendingInfo.write(separator.getBytes());
            sendingInfo.write(s2.getBytes());
            sendingInfo.write(separator.getBytes());
            sendingInfo.write(s3.getBytes());
            sendingInfo.write(separator.getBytes());
            sendingInfo.write("BYE".getBytes());
            sendingInfo.write(separator.getBytes());
            sendingInfo.flush();
            //停止输出最关键
            s.shutdownOutput();


            System.out.println("Client has been sent data, waiting....");
            //设置输入流，获取服务端给与的返回信息
            int len;
            byte[] bytes = new byte[1024];
            while ((len = in.read(bytes)) != -1) {
                System.out.println("get the information is : " + new String(bytes, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
