package other.primitiveType;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class AboutChar {
    public static void main(String[] args) {
        testGrammar();
        testByteSize3();
        testByteSize4();
        testMaxCodePoint();
    }

    public static void testGrammar() {
        char test1 = 65;
        System.out.println(test1);//should be A
        char test2 = '\u2122';
        System.out.println(test2);//是注册符号TM
        //common one : char test3 = 'a';
        char test3 = '\u08B2';
        System.out.println(test3);
    }

    public static void testByteSize4() {
        System.out.println(">>> the byte number is 4");
        int codePoint = 0x1FA80;
        showCodePoint(codePoint);
    }

    public static void testByteSize3() {
        System.out.println(">>> the byte number is 3");
        int codePoint = 0x08B2;
        showCodePoint(codePoint);
    }

    public static void testMaxCodePoint(){
        System.out.println(">>> testMaxCodePoint");
        int codePoint = 0x100F00;
        showCodePoint(codePoint);
    }


    private static void showCodePoint(int codePoint) {
        System.out.println("码点是：" + "U+" + Integer.toHexString(codePoint).toUpperCase());

        char[] chars = Character.toChars(codePoint);
        System.out.println("char 的数量：" + chars.length);

        //展示蜗牛
        String snail = new String(chars);
        System.out.println("具体字符是：" + snail);

        int byteNum = snail.getBytes(StandardCharsets.UTF_8).length;
        System.out.println("占用的字节长度： " + byteNum);
    }

}
