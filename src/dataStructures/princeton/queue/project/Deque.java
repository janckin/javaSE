package dataStructures.princeton.queue.project;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {


    private Node first, end;
    private int size;

    /**
     * create node
     */
    private class Node {
        public Item item;
        public Node previous;
        public Node next;

        public Node(Item item, Node pre, Node next) {
            this.item = item;
            this.previous = pre;
            this.next = next;
        }
    }

    /**
     * construct an empty deque
     */
    public Deque() {
        size = 0;
        first = null;
        end = null;
    }

    /**
     * is the deque empty?
     *
     * @return result
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return the number of items on the deque
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * add the item to the front
     *
     * @param item item wanted to add
     */
    public void addFirst(Item item) {
        justifyNull(item);
        Node newFirst = new Node(item, null, null);
        if (isEmpty()) {
            first = newFirst;
            end = first;
        } else {
            newFirst.next = first;
            first.previous = newFirst;
            first = newFirst;
        }
        size++;
    }

    /**
     * add the item to the back
     *
     * @param item item wanted to add
     */
    public void addLast(Item item) {
        justifyNull(item);
        Node newEnd = new Node(item, null, null);
        if (isEmpty()) {
            first = newEnd;
        } else {
            if (end == null) {
                end = newEnd;
                end.previous = first;
            } else {
                end.next = newEnd;
                newEnd.previous = end;
                end = newEnd;
            }
        }
        size++;
    }

    /**
     * remove and return the item from the front
     *
     * @return removed item
     */
    public Item removeFirst() {
        justifyEmpty();
        Node oldFirst = first;
        Node newFirst = first.next;
        first = newFirst;
        if (first != null) {
            first.previous = null;
        }
        size--;
        return oldFirst.item;
    }

    /**
     * remove and return the item from the back
     *
     * @return removed item
     */
    public Item removeLast() {
        justifyEmpty();
        Item item = end.item;
        end = end.previous;
        size--;
        if (isEmpty()) first = end;
        else end.next = null;
        return item;
    }

    /**
     * return an iterator over items in order from front to back
     *
     * @return DequeIterator class
     */
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            if (current == null) {
                return false;
            }
            return current.next == null;
        }

        @Override
        public Item next() {
            if (!hasNext() || current == null) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }


    }

    public void print() {
        if (first == null) {
            System.out.println("first is null");
        }
        if (end == null) {
            System.out.println("end is null");
        }
        System.out.println("list begin!--->");
        Node current = first;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

    /*unit testing (required)*/
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.print();
        deque.removeLast();
        deque.addFirst(4);
        deque.addFirst(5);
        deque.addFirst(6);
        deque.print();
        deque.removeFirst();
        deque.print();
    }

    /**
     * corner case : null
     *
     * @param item parameter
     */
    private void justifyNull(Item item) {
        if (item == null) throw new IllegalArgumentException();
    }

    /**
     * corner case : empty condition
     */
    private void justifyEmpty() {
        if (isEmpty()) throw new NoSuchElementException();
    }

}