package netWork;

import enumKnowledge.Season;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class MyServerSocketError {
    public static void main(String[] args) {
        communicateWithClientClass();
    }

    public static void communicateWithClientClass() {
        int port = 8189;
        try (ServerSocket serverSocket = new ServerSocket(port)){
            Socket s = serverSocket.accept();
            InputStream in = s.getInputStream();
            OutputStream sendingInfo = s.getOutputStream();

            System.out.println(">>>>>>Server has been connected>>>>");

            String info;
            Season season;

            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            boolean flag = false;
            while (!flag && Objects.nonNull(info = bf.readLine())) {
                System.out.println("server get the information : " + info);
                //end the link
                try {//符合条件就调用
                    season = Season.valueOf(info);
                    sendingInfo.write(season.getValue().getBytes());
                    System.out.println("have sent data: " + season.getValue());
                } catch (IllegalArgumentException ignored) {
                }
                if(info.equals("BYE")) flag = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
