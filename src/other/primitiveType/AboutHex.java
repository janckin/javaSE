package other.primitiveType;

import java.util.Arrays;

public class AboutHex {
    public static void main(String[] args) {
        int[] a = {0b10000, 16, 020, 0x10};//都是16
        Arrays.stream(a).forEach(System.out::println);
    }
}
