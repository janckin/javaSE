package regularExpression;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        testSplit();
        //testGroup();
        //testPatterMethods();
    }
    //测试分割
    public static void testSplit(){
        String target = "AAA456456VVV0532214DDD__RRR--GG";
        String patternStr = "\\d+";//以数字为分割符分割,后面的DDD__RRR--GG不会被切割
        Pattern p = Pattern.compile(patternStr);
        String[] strings = p.split(target);
        Arrays.stream(strings).forEach(System.out::println);
    }

    public static void testGroup(){
        String number1 = "123 555 6662";
        //假设前3位是区号，中间三位的随机号，最后4位验证号
        String patternStr = "(\\d{3}).(\\d{3}).(\\d{4})";
        Pattern p = Pattern.compile(patternStr);
        Matcher matcher1 = p.matcher(number1);
        while(matcher1.find()){
            int num = matcher1.groupCount();
            for (int i = 1; i <= num; i++) {
                System.out.println(matcher1.group(i));
            }
        }
    }

    public static void testPatterMethods(){
        Pattern p1 = Pattern.compile("^.*b.*$");
        //输出false,因为正则表达式中出现了^或$，默认只会匹配第一行，第二行的b匹配不到。
        System.out.println(p1.matcher("a\nb").find());
        Pattern p2 = Pattern.compile("^.*b.*$",Pattern.MULTILINE);
        //输出true,指定了Pattern.MULTILINE模式，就可以匹配多行了。
        System.out.println(p2.matcher("a\nb").find());
    }
}
