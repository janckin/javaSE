package testIO.NIO.Jackin;

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

            ByteBuffer buffer = ByteBuffer.allocate(256);

            //set up selector, 准备启动 epoll 或者select
            Selector selector = Selector.open();
            //register selector
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            while (selector.select() > 0) {
                //iterate all key，就是获取所有注册好的连接
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    System.out.println("come in once");
                    SelectionKey key = it.next();
                    //先移除，以防占据过多内存
                    it.remove();

                    if (key.isAcceptable()) {
                        //获得可以连接的socketChannel
                        SocketChannel sc = ssc.accept();
                        sc.configureBlocking(false);

                        //将写权限放入
                        sc.register(selector, SelectionKey.OP_WRITE);
//                        continue;
                    }


                    if (key.isWritable()) {
                        SocketChannel sc = (SocketChannel) key.channel();
                        buffer.clear();
                        //客户端第一次连接到服务端，服务端发送连接成功语句
                        buffer.put("server is connected!".getBytes());
                        buffer.flip();
                        sc.write(buffer);

                        //准备读取客户端的消息
                        sc.register(selector, SelectionKey.OP_READ);
                    }else if (key.isReadable()) {
                        SocketChannel sc = (SocketChannel) key.channel();
                        buffer.clear();
                        //展示客户端的信息，并结束
                        System.out.println("server collect words:");
                        int len = sc.read(buffer);
                        if (len > 0) {
                            buffer.flip();
                            System.out.println(new String(buffer.array(), buffer.position(), len));
                        }

                        //告知客户端已经接收了全部消息
                        /*writeBuffer.put("data received!".getBytes());
                        writeBuffer.flip();
                        sc.write(writeBuffer);*/
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
