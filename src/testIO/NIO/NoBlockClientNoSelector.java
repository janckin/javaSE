package testIO.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NoBlockClientNoSelector {
    public static void main(String[] args) {
        int clientNumber = 5;
        for (int i = 0; i < clientNumber; i++) {
            String name = "ClientNoSelect" + i;
            new Thread(() -> {
                ClientNoSelect c1 = new ClientNoSelect(name);
                c1.request();
            }).start();
        }
    }
}

class ClientNoSelect {
    String name;

    ClientNoSelect(String name) {
        this.name = name;
    }

    public void request() {
        try (SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(8083))) {
            socketChannel.configureBlocking(false);
            ByteBuffer bf = ByteBuffer.allocate(32);
            System.out.println(name + ", message from server:");
            int len;
            while ((len = socketChannel.read(bf)) > 0) {
                bf.flip();
                String word = new String(bf.array(), bf.position(), len);
                System.out.println(word);
            }

            ByteBuffer bf2 = ByteBuffer.allocate(1024);
            bf2.put(("connection success!" + name + "'s data: hello world").getBytes());
            bf2.flip();
            socketChannel.write(bf2);
            socketChannel.shutdownOutput();

            System.out.println(name + ", message from server:");
            ByteBuffer bf3 = ByteBuffer.allocate(1024);
            int len2;
            while ((len2 = socketChannel.read(bf3)) > 0) {
                bf3.flip();
                String word = new String(bf3.array(), 0, len2);
                System.out.println(word);
                //Thread.sleep(10);
            }
        } catch (IOException e) {
            if (e.getMessage().contains("Connection reset")) {
                System.out.println("connection closed");
            }
        }/*catch (InterruptedException ex){
            ex.printStackTrace();
        }*/
    }
}