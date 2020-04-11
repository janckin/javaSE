package testCollection.list;

//双向链表节点
public class DuLNode {
    private DuLNode prior;
    private DuLNode next;
    private Object data;

    public DuLNode() {
    }

    public DuLNode(Object data) {
        this.data = data;
        this.next = null;
        this.prior = null;
    }

    public DuLNode getPrior() {
        return prior;
    }

    public void setPrior(DuLNode prior) {
        this.prior = prior;
    }

    public DuLNode getNext() {
        return next;
    }

    public void setNext(DuLNode next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
