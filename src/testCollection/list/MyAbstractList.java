package testCollection.list;

public abstract class MyAbstractList implements MyList {
    protected int size = 0;

    protected MyAbstractList() {

    }

    protected MyAbstractList(Object[] objects) {
        for (Object object : objects) {
            this.add(object);
        }
    }

    public void add(Object o) {
        add(size, o);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean remove(Object o) {
        if (indexOf(o) >= 0) {
            remove(indexOf(o));
            return true;
        } else {
            return false;
        }
    }

}
