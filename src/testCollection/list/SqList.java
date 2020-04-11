package testCollection.list;

public class SqList implements IList {
    protected Object[] listElem;
    protected int curLen;

    public SqList() {
    }

    public SqList(int maxSize) {
        super();
        this.curLen = 0;
        listElem = new Object[maxSize];
    }

    @Override
    public void clear() {
        curLen = 0;
    }

    @Override
    public int length() {
        return curLen;
    }

    @Override
    public boolean isEmpty() {
        return curLen == 0;
    }

    @SuppressWarnings("all")
    @Override
    public void insert(int index, Object o) {
        testIndex(index);
        if (listElem.length == curLen) {
            throw new RuntimeException("顺序表已满");
        }
        for (int j = curLen; j < index; j--) {
            listElem[j] = listElem[j - 1];
        }
        listElem[index] = o;
        curLen++;
    }

    @Override
    public Object get(int index) {
        testIndex(index);
        if (isEmpty()) {
            return null;
        }
        return listElem[index];
    }

    @Override
    public void remove(int i) {
        testIndex(i);
        for (int j = i; i < curLen - 1; i++) {
            listElem[j] = listElem[j + 1];
        }
        curLen--;

    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < curLen; i++) {
            if (listElem[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void display() {
        System.out.println("sqList content : " + " ");
        for (Object x : listElem) {
            System.out.print(x + " ");
        }
    }

    private void testIndex(int index) {
        if (index < 0 || index > curLen) {
            throw new IndexOutOfBoundsException();
        }
    }

}
