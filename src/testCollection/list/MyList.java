package testCollection.list;

interface MyList {
    void add(Object o);

    void add(int index, Object o);

    void clear();

    Object get(int index);

    int indexOf(Object o);

    boolean isEmpty();

    int lastIndexOf(Object o);

    boolean remove(Object o);

    int size();

    Object remove(int index);

    Object set(int index, Object o);
}
