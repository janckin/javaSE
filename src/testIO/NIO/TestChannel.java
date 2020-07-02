package testIO.NIO;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;

public class TestChannel {

    static final String PUBLIC_PATH = "F:" + File.separator + "test3" + File.separator;

    public static void main(String[] args) {
        Instant start = Instant.now();
        testDirectBuffer();
        Instant endOfTest1 = Instant.now();
        System.out.println("利用直接缓冲区复制用时:" + Duration.between(start, endOfTest1).toMillis());
        testJVMBufferWithStream();
        Instant endOfTest2 = Instant.now();
        System.out.println("利用非直接缓冲区复制用时:" + Duration.between(endOfTest1, endOfTest2).toMillis());
        testTransformInChannel();
        Instant endOfTest3 = Instant.now();
        System.out.println("利用通道复制用时:" + Duration.between(endOfTest2, endOfTest3).toMillis());
    }

    //通道间直接传输
    public static void testTransformInChannel() {
        Path oldPath = Paths.get(PUBLIC_PATH, "focus.pdf");
        Path newFilePath = Paths.get(PUBLIC_PATH, "focus_transformInChannel.pdf");

        try (//build up channel
             FileChannel inChannel = FileChannel.open(oldPath, StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(newFilePath, StandardOpenOption.CREATE, StandardOpenOption.READ, StandardOpenOption.WRITE)
        ) {
            inChannel.transferTo(0, inChannel.size(), outChannel);
            //相当于
            //outChannel.transferFrom(inChannel, 0, inChannel.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //利用open这个静态方法获取channel
    // 如果采用通道操作，参考@testJVMBufferWithStream()
    // 如果采用直接缓冲的方式, 参考下面的方法
    public static void testDirectBuffer() {
        Path oldPath = Paths.get(PUBLIC_PATH, "focus.pdf");
        Path newFilePath = Paths.get(PUBLIC_PATH, "focus_directBufferInMap.pdf");

        try (//build up channel
             FileChannel inChannel = FileChannel.open(oldPath, StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(newFilePath, StandardOpenOption.CREATE, StandardOpenOption.READ, StandardOpenOption.WRITE)
        ) {
            //通过设置映射, 就已经建立好了直接缓冲区
            MappedByteBuffer inMap = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMap = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            //设置要缓冲区的大小, 让2个MappedByteBuffer类自己进行操作
            byte[] buffer = new byte[inMap.limit()];
            inMap.get(buffer);
            outMap.put(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //利用流获取channel，传输通道
    public static void testJVMBufferWithStream() {
        Path oldPath = Paths.get(PUBLIC_PATH, "focus.pdf");
        Path newFilePath = Paths.get(PUBLIC_PATH, "focus_copy_Stream.pdf");

        try (//build up channel
             FileInputStream in = new FileInputStream(new File(oldPath.toUri()));
             FileOutputStream out = new FileOutputStream(new File(newFilePath.toUri()));
             FileChannel inChannel = in.getChannel();
             FileChannel outChannel = out.getChannel()
        ) {

            //ready for send data
            ByteBuffer bf = ByteBuffer.allocate(1024);
            while (inChannel.read(bf) != -1) {
                inChannel.read(bf);
                bf.flip();
                outChannel.write(bf);
                bf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
