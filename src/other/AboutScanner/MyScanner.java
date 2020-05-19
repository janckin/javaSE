package other.AboutScanner;

import java.util.Objects;
import java.util.Scanner;

public class MyScanner {
    public static void main(String[] args) {
        //test();
        //testPrintFPrimitiveType();
        //testPrintFHex();
        //testPrintFFloat();
        testStringFormat();
    }

    public static void test() {
        Scanner in = new Scanner(System.in);
        System.out.println("读取内容的方法>>>>");
        System.out.println("请输入您的名字：");
        String name = in.nextLine();
        System.out.println("请输入您的年龄：");
        int age = in.nextInt();
        System.out.println(name + ":" + age + "岁");

        System.out.println("测试next方法：");
        System.out.println("next方法: " + in.next());
    }

    private static void testPrintFPrimitiveType() {
        String name = "john";
        int age = 10;
        String address = "Canton";
        char c = 'y';
        System.out.printf("%s lives in %s when he was %d years old %n", name, address, age);
        System.out.printf("it is similar to %c %n",c);
        System.out.printf("hashcode of age is %h %n", Objects.hash(age));
        System.out.printf("the percentage of boy is %d%% %n",66);
    }

    private static void testPrintFHex() {
        int octal = 073;
        boolean hello = false;
        int hexadecimal = 0x3f;
        System.out.printf("%o number is octal, boolean data is %b, %x number is hexadecimal", octal, hello, hexadecimal);
    }

    private static void testPrintFFloat() {
        System.out.printf("number: %.1f number %n", Math.PI);//保留1位小数
        System.out.printf("number : %+d  %n",-88);//整数位2字符位，16bits(0个小数)
    }
    private static void testStringFormat(){
        System.out.println(String.format("your name is %s and will be %d years old next year", "trump",99));
    }
}
