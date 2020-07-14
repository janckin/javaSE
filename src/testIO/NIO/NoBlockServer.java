package testIO.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NoBlockServer {
    public static void main(String[] args) {
        try (ServerSocketChannel ssc = ServerSocketChannel.open()) {
            //set up socket channel
            ssc.bind(new InetSocketAddress(8083));
            ssc.configureBlocking(false);

            //set up selector, 准备启动 epoll 或者select
            Selector selector = Selector.open();
            //register selector
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            while (selector.select() > 0) {
                //iterate all key，就是获取所有注册好的连接
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    //先移除，以防占据过多内存
                    it.remove();

                    if (key.isAcceptable()) {
                        //获得可以连接的socketChannel
                        SocketChannel sc = ssc.accept();
                        sc.configureBlocking(false);

                        //将写权限放入
                        sc.register(selector, SelectionKey.OP_WRITE);
                        continue;
                    }

                    SocketChannel sc = (SocketChannel) key.channel();
                    if (key.isWritable()) {
                        ByteBuffer writeBuffer = ByteBuffer.allocate(256);
                        //客户端第一次连接到服务端，服务端发送连接成功语句
                        writeBuffer.put("server is connected!".getBytes());
                        writeBuffer.flip();
                        sc.write(writeBuffer);

                        //准备读取客户端的消息
                        sc.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        //展示客户端的信息，并结束
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                        int len = sc.read(readBuffer);
                        if (len > 0) {
                            readBuffer.flip();
                            System.out.println("server collect words:");
                            System.out.println(new String(readBuffer.array(), 0, len));
                        }

                        //告知客户端已经接收了全部消息
                        ByteBuffer writeBuffer = ByteBuffer.allocate(256);
                        writeBuffer.put("data received! over!".getBytes());
                        writeBuffer.flip();
                        sc.write(writeBuffer);

                        //Thread.sleep(3000);
                        //单个客户端没问题，多个就不行了
                        sc.close();
                    }
                }
            }
        } catch (IOException e) {
            if (e.getMessage().contains("Connection reset")) {
                System.out.println("connection closed");
            } else {
                e.printStackTrace();
            }
        }/* catch (InterruptedException ex) {
            ex.printStackTrace();
        }*/
    }
}
