package generic;

import java.io.Serializable;

public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"m","h","a","l","b"};
        Pair<String> pair = ArrayAlg.minmax(words);
        System.out.println("min: "+pair.getFirst());
        System.out.println("max: "+pair.getSecond());

        System.out.println("the middle of 0-2 is: " + ArrayAlg.getMiddle(words[0],words[1],words[2]));
        System.out.println("the length is: " + ArrayAlg.getLength(words[0],words[1],words[2]));

        System.out.println("the minium of 0-2 is: " + ArrayAlg.min(words[0],words[1],words[2]));

    }
}

class ArrayAlg {
    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) return new Pair<>();
        String min = a[0];
        String max = a[0];
        for (String str : a) {
            if(str.compareTo(min) < 0) min = str;
            if(str.compareTo(max) > 0) max = str;
        }
        return new Pair<>(min,max);
    }

    @SafeVarargs
    //use T and return T
    public static <T> T getMiddle(T ... a){
        for(T t:a){
            System.out.println("the t is "+ t.toString());
        }
        return a[a.length/2];
    }

    @SafeVarargs
    //parameters are T and use T in method
    public static <T> int getLength(T ... a){
        for(T t:a){
            System.out.println(t.toString());
        }
        return a.length;
    }

    @SafeVarargs
    public static <T extends Comparable<T> & Serializable> T min(T ... a){
        if (a == null || a.length == 0) return null;
        T min = a[0];
        for (T t : a) {
            if(t.compareTo(min) < 0) min = t;
        }
        return min;
    }
}
