package stack;

import list.SqList;

public class SqStack extends SqList implements IStack {

    public SqStack() {
        // TODO Auto-generated constructor stub
        super();
    }

    public SqStack(int maxSize) {
        super(maxSize);
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        super.clear();

    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return super.isEmpty();
    }

    @Override
    public void push(Object o) {
        super.insert(curLen, o);
    }

    @Override
    public Object peek() {
        // TODO Auto-generated method stub
        return super.get(curLen - 1);
    }

    @Override
    public int length() {
        // TODO Auto-generated method stub
        return super.length();
    }

    @Override
    public Object pop() {
        // TODO Auto-generated method stub
        Object o = super.get(curLen - 1);
        curLen--;
        return o;
    }

}
