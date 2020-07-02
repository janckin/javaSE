package testIO.NIO;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class TestBuffer {
    public static void main(String[] args) {
        //testFourVariables();
        testMark();
    }

    public static void testFourVariables() {
        String inputStr = "hello world!";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);//this method sets the size of ByteBuffer array

        /*
         * capacity: 代表着底层数组的大小
         * limit: 代表着可以读取的最大index, 即所谓的再此以后无法读取或写入
         * position: 一个记录已填数据的下1位指针, 即下一个可写入的位置
         * mark: 记录position的上1位, 方便调用
         */
        System.out.println("initialise four variables: ");
        printFourVariables(byteBuffer);

        //put 方法写入数据
        byteBuffer.put(inputStr.getBytes());
        System.out.println("After put data: ");
        printFourVariables(byteBuffer);

        //用flip方法转化位读数据模式, 注意limit的变化
        byteBuffer.flip();
        System.out.println("After flip: ");
        printFourVariables(byteBuffer);
        //没有调用flip方法, 会报错BufferUnderflowException
        //byte[] resultByteArr = new byte[1024];

        //用get方法获取录入的数据, 其中可以设置究竟读取多少内容
        byte[] resultByteArr = new byte[byteBuffer.limit()];
        byteBuffer.get(resultByteArr, 0, resultByteArr.length);
        System.out.println("get the data :" + new String(resultByteArr));
        System.out.println("After get data: ");
        printFourVariables(byteBuffer);

        //读取limit后续的位置会报错
        //byteBuffer.get(byteBuffer.limit() + 1);


        //用完get方法, 会发现其实底层数组没有被清空,依旧在, 而position不变
        byte firstByte = byteBuffer.get(0);
        System.out.println("get a byte: " + Arrays.toString(Character.toChars(firstByte)));
        System.out.println("After get a byte: ");
        printFourVariables(byteBuffer);


        //clear方法: 将所有坐标重置, 但实际内容还是在的
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.clear();
        System.out.println("after clear: ");
        printFourVariables(byteBuffer);
        byteBuffer.get(bytes);
        System.out.println(new String(bytes));

        //可重复读
        byteBuffer.rewind();
        System.out.println("after rewind: ");
        printFourVariables(byteBuffer);
        byte[] rewindBytes = new byte[byteBuffer.limit()];
        byteBuffer.get(rewindBytes);
        System.out.println(new String(rewindBytes));
    }

    public static void testMark() {
        String inputStr = "hello world!";
        ByteBuffer byteBuffer = ByteBuffer.allocate(12);//this method sets the size of ByteBuffer array

        byteBuffer.put(inputStr.getBytes());
        byteBuffer.position(0);
        //正常情况下
        while (byteBuffer.hasRemaining()) {
            System.out.print(Character.toChars(byteBuffer.get()));
        }

        //可以使用mark令其不断循环
        System.out.println(System.getProperty("line.separator") + "----use mark!----");
        byteBuffer.position(2);
        byteBuffer.mark();

        int i = 0;
        while (byteBuffer.hasRemaining() && i <= 13) {
            System.out.print(Character.toChars(byteBuffer.get()));
            if (i == 3) {
                byteBuffer.reset();
            }
            i++;
        }
        System.out.println();

    }

    private static void printFourVariables(ByteBuffer byteBuffer) {
        System.out.println("capacity is: " + byteBuffer.capacity());
        System.out.println("limit is: " + byteBuffer.limit());
        System.out.println("position is: " + byteBuffer.position());
    }
}
