package stack;

//栈
public interface IStack {
    public void clear();//清空栈

    public boolean isEmpty();//是否为空栈

    public void push(Object o);//压栈；入栈

    public Object peek();//返回栈顶元素

    public int length();//获取栈空格键按

    public Object pop();//出栈
}
