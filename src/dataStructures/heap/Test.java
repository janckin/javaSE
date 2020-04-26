package dataStructures.heap;

public class Test {
    public static void main(String[] args) {
        testAdd();
    }

    public static void testAdd() {
        MyBinaryHeap heap = new MyBinaryHeap();
        heap.add(30);
        heap.add(35);
        heap.add(50);
        assert("30 ; 35 ; 50 ; ".equals(heap.toString()));
        heap.add(19);
        assert("19 ; 30 ; 50 ; 35 ; ".equals(heap.toString()));
        heap.add(17);
        assert("17 ; 19 ; 50 ; 35 ; 30 ; ".equals(heap.toString()));
        heap.add(51);
        heap.add(52);
        heap.add(16);
        assert("16 ; 17 ; 50 ; 19 ; 30 ; 51 ; 52 ; 35 ; ".equals(heap.toString()));
        System.out.println(" >> pass add >> ");
    }
}
