package testStream;

import java.util.Optional;

public class TestOptional {

    public static void main(String[] args) {
        Double x = 4.0;
        Optional<Double> optional = inverseSqrt(4.0);
        System.out.println(optional.orElseThrow(IllegalArgumentException::new));
    }

    //获取平方根
    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }

    //获取倒数
    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    //利用flatMap获取倒数的平方根
    public static Optional<Double> inverseSqrt(Double x) {
        return inverse(x).flatMap(TestOptional::squareRoot);
    }

}
