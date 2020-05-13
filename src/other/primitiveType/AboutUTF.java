package other.primitiveType;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class AboutUTF {
    public static void main(String[] args) {
        UTF16Encoding();
        UTF8Encoding();
    }
    static int codePoint = 0x20BB7;
    public static void UTF16Encoding() {
        //step1:需要计算的差值 : codePoint - 0x10000;
        //B: 1 0000 1011 1011 0111
        //H：0x10BB7‬
        //step2: 把差值换算成20位:0001 0000 1011 1011 0111
        //step3: 切割前10位高位差值，后10位为低位差值
        //高位差值: 0001 0000 10 = 0x42
        //后10位 : 11 1011 0111 = 0x3B7
        //step4: 分别加上高位最小值0xDC00，和低位最小值0xD800，获取最终分割的2个字节
        //high : 0x42 + 0xD800 = 0xD842‬
        //low : 0x3B7 + 0xDC00 = 0xDFB7‬
        char[] chars = Character.toChars(codePoint);
        System.out.println("high 16进制数：" + Integer.toHexString(chars[0]));
        System.out.println("low 16进制数：" + Integer.toHexString(chars[1]));
        System.out.println(new String(chars));
    }

    public static void UTF8Encoding(){
        //step1: code point 变为2进制：0010 0000 1011 1011 0111
        //step2: 虽然是18位二进制数，但需要补齐21位有效，以便生成4个字节
        //step3: 生成字节:
        //第1个字节: 11110....: 1111 0000 = F0
        //第2个字节: 10.......: 1010 0000 = A0
        //第3个字节: 10.......: 1010 1110 = AE
        //第4个字节: 10.......: 1011 0111 = B7

        char[] cs = Character.toChars(codePoint);
        String s = new String(cs);
        String utf8 = URLEncoder.encode(s, StandardCharsets.UTF_8);
        System.out.println(utf8);  // %F0%A0%AE%B7


        int codePoint2 = 0b10110111;
        char[] cs2 = Character.toChars(codePoint2);
        String s2 = new String(cs2);
        String utf82 = URLEncoder.encode(s2, StandardCharsets.UTF_8);
        System.out.println(utf82);

    }


}
