package testStream;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCollectResult {
    public static void main(String[] args) {
        //只是获取一些特性
        Stream<String> stream = Stream.of("hello","only","a","word");

        //比如根据字符内容计算
        IntSummaryStatistics intSummaryStatistics = stream.collect(Collectors.summarizingInt(String::length));
        double lenAverage = intSummaryStatistics.getAverage();
        double lenSum = intSummaryStatistics.getSum();
        double lenMax = intSummaryStatistics.getMax();
        System.out.println("the average string length is stream: "+lenAverage);
        System.out.println("the total string length is stream: "+lenSum);
        System.out.println("the maximum string length is stream: "+lenMax);
    }
}
