package testLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StaticInnerClass {
    //test
    public static void main(String[] args) {
        double[] d = new double[20];
        StringBuilder sb = new StringBuilder("the original array: ");
        for (int i = 0; i < 20; i++) {
            d[i] = 100 * Math.random();
            sb.append(d[i]).append(" ");
        }
        System.out.println(sb);
        ArrayAlg.Pair pair = ArrayAlg.minmax(d);
        System.out.println("max is:" + pair.getFirst());
        System.out.println("min is:" + pair.getSecond());
        List<Double> list = new ArrayList<>();
    }
}

class FuntionalInterface {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(100 * Math.random());
        }
        System.out.println(list.toString());
        Stream<Double> stream = list.stream();
        stream.forEach(new Consumer<Double>(){
            @Override
            public void accept(Double aDouble) {
                System.out.println(aDouble);
            }
        });
        stream.forEach(System.out::println);
    }
}

class ArrayAlg {
    static class Pair {
        private double first, second;

        Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }

    public static Pair minmax(double[] vals) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double val : vals) {
            if (val < min) min = val;
            if (val > max) max = val;
        }
        return new Pair(min, max);
    }
}