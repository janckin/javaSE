package dataStructures.fundamentals;

import java.util.Iterator;

//only use in depth first path
public class BagForDFP<T> extends Bag<T> {

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = pop;

            @Override
            public boolean hasNext() {
                return !Node.isNullNode(current);
            }

            @Override
            public T next() {
                Node<T> result = current;
                current = result.previous;
                return result.data;
            }
        };
    }
}
