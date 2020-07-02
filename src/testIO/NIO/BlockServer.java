package testIO.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class BlockServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8083));
        SocketChannel sc = ssc.accept();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        String str = "connected successfully";
        byteBuffer.put(str.getBytes());
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            sc.write(byteBuffer);
        }

        sc.shutdownOutput();

        byteBuffer.clear();
        byte[] bytes = new byte[256];
        try {
            while (sc.read(byteBuffer) != -1) {
                byteBuffer.flip();
                byteBuffer.get(bytes, byteBuffer.position(), byteBuffer.limit());
                String message = new String(bytes);
                if (message.isEmpty()) {
                    System.out.println("couldn't get data from client");
                } else {
                    System.out.println("data from client: ");
                    System.out.println(message);
                }
                byteBuffer.compact();
            }
        } catch (RuntimeException runtimeException) {
            System.out.println(runtimeException.getMessage());
        }
        sc.close();
        ssc.close();
    }
}
