package testIO.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class BlockClient {
    public static void main(String[] args) {
        //get the input stream and output stream
        try {
            SocketChannel sc = SocketChannel.open(new InetSocketAddress(8083));
            System.out.println("client:");

            //buffer
            ByteBuffer bb = ByteBuffer.allocate(256);

            //get data
            boolean gotData = false;
            System.out.println("------ get data from server -----");
            while (sc.read(bb) != -1) {
                bb.flip();
                String str = new String(bb.array(), bb.position(), bb.limit());
                if (!str.isEmpty() && !str.isBlank()) {
                    System.out.println(str);
                    gotData = true;
                }
                bb.compact();
            }
            System.out.println("------ finish -----");

            //write data
            if (!gotData) {
                throw new RuntimeException("fail to get data from server");
            }
            bb.clear();
            System.out.println("------ start sent data to server -----");
            bb.put("client has get the data and send new data".getBytes());
            bb.flip();
            while (bb.hasRemaining()) {
                sc.write(bb);
            }
            System.out.println("------ finish -----");
            sc.shutdownOutput();

            sc.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (RuntimeException noMessageExp) {
            System.out.println(noMessageExp.getMessage());
        }
    }
}
