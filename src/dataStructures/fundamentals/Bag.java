package dataStructures.fundamentals;

import java.io.*;
import java.util.Iterator;

//ADT： abstract data type, this collection only allow data to input while delete is not allowed
public class Bag<T> implements Iterable<T> {
    private int size;
    /** use double link-list **/
    private Node<T> head;
    private Node<T> pop;

    public Bag() {
        size = 0;
        pop = new Node<>();
        head = pop;
    }

    public void add(T t) {
        Node<T> newNode = new Node<>(t);
        pop.next = newNode;
        newNode.previous = pop;
        pop = newNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return !Node.isNullNode(current.next);
            }

            @Override
            public T next() {
                Node<T> result = current.next;
                current = result;
                return result.data;
            }
        };
    }

    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(Bag.class.getResourceAsStream("stats.txt")))) {
            //test bag
            Bag<Integer> bag = new Bag<>();

            String s;
            while ((s = bf.readLine()) != null) {
                int i = Integer.parseInt(s);
                //System.out.println(i);
                bag.add(i);
            }
            for (Integer i : bag) {
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
