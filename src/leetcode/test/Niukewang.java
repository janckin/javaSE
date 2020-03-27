package leetcode.test;

public class Niukewang {
    public static void main(String[] args) {
        Byte b = 127;
        add(b);
        System.out.println(b);
        /*B object_b = new B();
        addObject3(object_b);
        System.out.println(object_b.a);*/

    }

    public static void add(Byte b) {
        b++;
    }

    public static void addObject(B b) {
        b.a++;
    }

    public static void addObject2(B b) {
        b.a = b.a++;
    }

    public static void addObject3(B b) {
        b.a = b.a;
        b.a++;
    }

    public static void addObject2EqualMethod(B b) {
        byte tmp = b.a;
        b.a = b.a;
        tmp++;
    }

    private static class B {
        public byte a = 0;
    }
}
