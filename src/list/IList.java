package list;

public interface IList {
    public void clear();

    public int length();

    public boolean isEmpty();

    public void insert(int index, Object o);

    public Object get(int index);

    public void remove(int i);

    public int indexOf(Object o);

    public void display();
}
