package dataStructures.heap;


import java.util.Objects;

//这是个小顶堆
@SuppressWarnings("rawtypes")
public class MyBinaryHeap {
    private Comparable[] data;
    private final int CAPACITY = 10;
    private int size;

    public MyBinaryHeap() {
        this.data = new Comparable[CAPACITY];
        this.size = 0;
    }

    public MyBinaryHeap(int capacity) {
        this.data = new Comparable[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public boolean add(Comparable context) {
        if (Objects.isNull(context)) return false;
        //build up a empty place
        data[0] = context;

        int hole = size + 1;
        while (context.compareTo(data[hole / 2]) < 0) {
            data[hole] = data[hole / 2];
            hole = hole / 2;
        }
        data[hole] = context;
        size++;

        //check arr size
        if (size == data.length) {
            extendArr();
        }
        return true;
    }

    public boolean remove(Comparable context) {
        if (Objects.isNull(context)) return false;
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].compareTo(context) == 0) {
                index = i;
                break;
            }
        }

        //reduce size
        if (size <= data.length / 4 && data.length > CAPACITY) {
            reduceArr();
        }
        return true;
    }

    public Comparable deleteMin() {
        if(isEmpty()) return null;
        Comparable targetCon = data[1];
        //set the last one to top
        data[1] = data[size];

        size--;
        return targetCon;
    }


    public boolean contain(Comparable context) {
        for (Comparable datum : data) {
            if (datum == null) continue;
            if (datum.compareTo(context) == 0) {
                return true;
            }
        }
        return false;
    }


    /**
     * default extension is double
     */
    private void extendArr() {
        extendArr(size * 2);
    }

    private void extendArr(int capacity) {
        if (capacity < data.length) {
            capacity += data.length;
        }
        Comparable[] newData = new Comparable[capacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    /**
     * default reduce is half of data
     */
    private void reduceArr() {
        int newLen = Math.max(data.length / 4, CAPACITY);
        Comparable[] newData = new Comparable[newLen];
        System.arraycopy(data, 0, newData, 0, newLen);
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < size + 1; i++) {
            sb.append(data[i].toString()).append(" ; ");
        }
        return sb.toString();
    }
}
