package stack;

import testCollection.list.SqList;

public class SqStack extends SqList implements IStack {

    public SqStack() {
        super();
    }

    public SqStack(int maxSize) {
        super(maxSize);
    }

    @Override
    public void clear() {
        super.clear();

    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public void push(Object o) {
        super.insert(curLen, o);
    }

    @Override
    public Object peek() {
        return super.get(curLen - 1);
    }

    @Override
    public int length() {
        return super.length();
    }

    @Override
    public Object pop() {
        Object o = super.get(curLen - 1);
        curLen--;
        return o;
    }

}
