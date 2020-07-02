package testIO.NIO;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//这个类测试通道的分散读取和聚集读取
public class TestChannel2 {
    public static void main(String[] args) {
        //testScatter();
        testGather();
    }

    //分散读取：将1个通道的数据，读取到多个缓冲区
    public static void testScatter() {
        String fileName = TestChannel.PUBLIC_PATH + "scatterTest.txt";
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();

            //build up byteBuffers
            ByteBuffer[] byteBuffers = {ByteBuffer.allocate(30), ByteBuffer.allocate(40), ByteBuffer.allocate(50)};

            //read data from file and write them into buffer
            fileChannel.read(byteBuffers);

            //buffer becomes read mode and see the result;
            int i = 1;
            for (ByteBuffer byteBuffer : byteBuffers) {
                byteBuffer.flip();

                System.out.println("No." + i + " buffer contains: ");
                System.out.println(new String(byteBuffer.array(), 0, byteBuffer.limit()));
                System.out.println("------------------------");
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //聚合写入：1个通多，将多个缓冲区的数据写入
    public static void testGather() {
        String fileName = TestChannel.PUBLIC_PATH + "scatterTest.txt";

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();

            //build up byteBuffers
            ByteBuffer[] byteBuffers = {ByteBuffer.allocate(30), ByteBuffer.allocate(40), ByteBuffer.allocate(50)};

            //read data from file and write them into buffer
            fileChannel.read(byteBuffers);
            for (ByteBuffer byteBuffer : byteBuffers) {
                byteBuffer.flip();
            }

            System.out.println("finish read file!");

            //here write the new file
            RandomAccessFile newFile = new RandomAccessFile(fileName + "_new.txt", "rw");
            FileChannel writeChannel = newFile.getChannel();
            writeChannel.write(byteBuffers);

            System.out.println("built up a new file");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
