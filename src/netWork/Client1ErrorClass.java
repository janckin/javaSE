package netWork;

import enumKnowledge.Season;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Objects;

public class Client1ErrorClass {
    public static void main(String[] var0) {
        short port = 8189;

        try {
            Socket s = new Socket("localhost", port);

            try {
                OutputStream sendingInfo = s.getOutputStream();

                String info;
                try {
                    System.out.println("Client has been find Server!!!!!");
                    String s1 = "here is client, could you hear me???";
                    info = "if you get that, return my a parameter!";
                    String s3 = Season.AUTUMN.toString();
                    String separator = System.getProperty("line.separator");
                    sendingInfo.write(s1.getBytes());
                    sendingInfo.write(separator.getBytes());
                    sendingInfo.write(info.getBytes());
                    sendingInfo.write(separator.getBytes());
                    sendingInfo.write(s3.getBytes());
                    sendingInfo.flush();
                    s.shutdownOutput();
                    System.out.println("output end!");
                } catch (Throwable var10) {
                    if (sendingInfo != null) {
                        try {
                            sendingInfo.close();
                        } catch (Throwable var9) {
                            var10.addSuppressed(var9);
                        }
                    }

                    throw var10;
                }

                if (sendingInfo != null) {
                    sendingInfo.close();
                }

                System.out.println("Client has been sent data, waiting....");
                InputStream in = s.getInputStream();

                try {
                    BufferedReader bf = new BufferedReader(new InputStreamReader(in));

                    while(Objects.nonNull(info = bf.readLine())) {
                        System.out.println("client get the information : " + info);
                    }
                } catch (Throwable var11) {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (Throwable var8) {
                            var11.addSuppressed(var8);
                        }
                    }

                    throw var11;
                }

                if (in != null) {
                    in.close();
                }
            } catch (Throwable var12) {
                try {
                    s.close();
                } catch (Throwable var7) {
                    var12.addSuppressed(var7);
                }

                throw var12;
            }

            s.close();
        } catch (IOException var13) {
            var13.printStackTrace();
        }

    }
}
