package netWork;

import enumKnowledge.Season;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class MyServerSocket {
    public static void main(String[] args) {
        //onlyInputInTerminal();
        communicateWithClientClass();
    }

    public static void communicateWithClientClass() {
        int port = 8189;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket s = serverSocket.accept();
             OutputStream sendingInfo = s.getOutputStream();
             InputStream in = s.getInputStream()){

            System.out.println(">>>>>>Server has been connected>>>>");

            String info;
            Season season;

            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            while (!(info = bf.readLine()).equals("BYE")) {
                System.out.println("server get the information : " + info);
                //end the link
                try {//符合条件就调用
                    season = Season.valueOf(info);
                    sendingInfo.write(season.getValue().getBytes(StandardCharsets.UTF_8));
                    System.out.println("have sent data: " + season.getValue());
                } catch (IllegalArgumentException ignored) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void onlyInputInTerminal() {
        int port = 8189;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            try (Socket s = serverSocket.accept()) {
                try (InputStream comingInfo = s.getInputStream();
                     OutputStream sendingInfo = s.getOutputStream();
                     BufferedReader bf = new BufferedReader(new InputStreamReader(comingInfo))) {
                    PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(sendingInfo), true);
                    printWriter.println("Server has been connected");

                    boolean endInfo = false;
                    String info;
                    while (!endInfo && Objects.nonNull(info = bf.readLine())) {
                        printWriter.println("server get the information : " + info);
                        //end the link
                        if (info.trim().toUpperCase().contains("BYE")) endInfo = true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void read(InputStream in, OutputStream sendingInfo) throws IOException {
        String info;
        Season season;
        byte[] bytes = new byte[1024];
        int len;
        boolean endInfo = false;
        while (!endInfo && (len = in.read(bytes)) != -1) {
            info = new String(bytes, 0, len, StandardCharsets.UTF_8);
            System.out.println("client's information: "+info);
            try {//符合条件就调用
                season = Season.valueOf(info);
                String str = season.getValue();
                sendingInfo.write(str.getBytes(StandardCharsets.UTF_8));
                //sendingInfo.flush();
            } catch (IllegalArgumentException ignored) {
            }
            if (info.trim().toUpperCase().contains("BYE")) endInfo = true;
        }
    }
}
