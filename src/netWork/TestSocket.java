package netWork;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TestSocket {
    public static void main(String[] args) {
        testSocket();
        testSocket2();
        testSocket3();
        getIp();
    }

    public static void testSocket() {
        String host = "time-a.nist.gov";
        int port = 13;
        try (Socket s = new Socket(host, port); InputStreamReader r = new InputStreamReader(s.getInputStream())) {
            char[] chars = new char[16];
            while (r.read(chars) != -1) {
                String string = new String(chars);
                System.out.print(string);
                chars = new char[16];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testSocket2() {
        String host = "time-a.nist.gov";
        int port = 13;
        try (Socket s = new Socket(host, port)) {
            Scanner scanner = new Scanner(s.getInputStream(), StandardCharsets.UTF_8);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testSocket3() {
        String host = "time-a.nist.gov";
        int port = 13;
        Socket s = new Socket();
        try {
            s.connect(new InetSocketAddress(host, port));
            Scanner scanner = new Scanner(s.getInputStream(), StandardCharsets.UTF_8);
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getIp() {
        try {
            String host = "www.baidu.com";
            InetAddress inetAddress = InetAddress.getByName(host);
            String nowIp = inetAddress.getHostAddress();//这个会变，因为服务器的负载均衡
            System.out.println("first ip:" + nowIp);

            //获取全部的ip地址
            System.out.println("all ips:");
            InetAddress[] inetAddresses = InetAddress.getAllByName(host);
            for (int i = 0; i < inetAddresses.length; i++) {
                System.out.println(inetAddresses[i].getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
