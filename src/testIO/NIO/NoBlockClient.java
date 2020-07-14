package testIO.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NoBlockClient {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            String name = "NoBlockClient" + i;
            new Thread(() -> {
                Client c1 = new Client(name);
                c1.request();
            }).start();
        }
    }
}

class Client {
    String name;

    Client(String name) {
        this.name = name;
    }

    public void request() {
        try  {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress(8083));
            socketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_READ);
            ByteBuffer bf = ByteBuffer.allocate(32);
            while (selector.select(16000) > 0) {
                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    SelectionKey key = keys.next();
                    keys.remove();
                    if (key.isReadable()) {
                        int len = socketChannel.read(bf);
                        String word;
                        if (len > 0) {
                            System.out.println(name + ", message from server:");
                            bf.flip();
                            word = new String(bf.array(), bf.position(), len);
                            System.out.println(word);
                            if (word.contains("over")) {
                                socketChannel.close();
                            }else {
                                socketChannel.register(selector, SelectionKey.OP_WRITE);
                            }
                        }
                    } else if (key.isWritable()) {
                        ByteBuffer bf2 = ByteBuffer.allocate(1024);
                        bf2.put(("connection success!" + name + "'s data: hello world").getBytes());
                        bf2.flip();
                        socketChannel.write(bf2);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    }
                }
            }
            socketChannel.close();
        } catch (IOException e) {
            if (e.getMessage().contains("Connection reset")) {
                System.out.println("connection closed");
            }
        }
    }
}