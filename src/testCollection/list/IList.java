package testCollection.list;

public interface IList {
    void clear();

    int length();

    boolean isEmpty();

    void insert(int index, Object o);

    Object get(int index);

    void remove(int i);

    int indexOf(Object o);

    void display();
}
