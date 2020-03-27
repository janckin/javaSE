package dataStructures.princeton.queue.project;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {


    private int size;
    private int CAPACITY = 10;
    private Item[] items;

    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
        items = (Item[]) new Object[CAPACITY];
    }

    /**
     * is the randomized queue empty?
     *
     * @return empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * return the number of items on the randomized queue
     *
     * @return the number of items
     */
    public int size() {
        return size;
    }

    /**
     * add the item
     *
     * @param item
     */
    public void enqueue(Item item) {
        justifyNull(item);
        items[size] = item;
        size++;
        //extends arrays
        if (size == items.length) {
            resize(2 * items.length);
        }
    }

    /**
     * remove and return a random item
     *
     * @return
     */
    public Item dequeue() {
        justifyEmpty();
        int deleteTarget = StdRandom.uniform(size);
        Item item = items[deleteTarget];
        for (int i = deleteTarget; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return item;
    }

    /**
     * return a random item (but do not remove it)
     *
     * @return
     */
    public Item sample() {
        justifyEmpty();
        return items[StdRandom.uniform(size)];
    }

    /**
     * return an independent iterator over items in random order
     *
     * @return
     */
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int length = size;
        private int[] order;

        public RandomizedQueueIterator() {
            order = new int[length];
            for (int j = 0; j < length; ++j) {
                order[j] = j;
            }
            StdRandom.shuffle(order);
        }

        @Override
        public boolean hasNext() {
            return length > 0;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[order[--length]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
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

    /**
     * extends items automatically
     */
    private void resize() {
        resize(CAPACITY);
    }

    private void resize(int capacity) {
        int newSize = items.length;
        if (capacity <= CAPACITY) {
            newSize += CAPACITY;
        } else {
            newSize += capacity;
        }
        Item[] newItems = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }

}
