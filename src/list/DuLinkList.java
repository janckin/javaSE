package list;

public class DuLinkList {
    private DuLNode head;

    public DuLinkList() {
        // TODO Auto-generated constructor stub
        head = new DuLNode();
        /*带头节点时必须设为自己，不然后续再insert 的时候会有问题
         * head.setNext(head);
         * head.setPrior(head);
         */
    }

    public DuLinkList(Object[] objects) {
        for (int i = 0; i < objects.length; i++) {
            insert(i, objects[i]);
        }
    }

    //不带头节点的insert
    public void insert(int i, Object x) {
        DuLNode newNode = new DuLNode(x);
        if (i == 0) {
            head = newNode;
            return;
        }
        if (i > length()) {
            throw new IndexOutOfBoundsException("传入的插入方法的i超出范围");
        }

        DuLNode currentNode = head;
        int j = 0;
        while (j < i && !currentNode.getNext().equals(head)) {
            currentNode = currentNode.getNext();
            j++;
        }
        DuLNode OldCurrentNext = currentNode.getNext();
        newNode.setNext(OldCurrentNext);
        newNode.setPrior(currentNode);
        currentNode.setNext(newNode);
        OldCurrentNext.setPrior(newNode);

    }

    public void remove(int i) {

    }

    public void clear() {
        head = new DuLNode();
    }

    public void isEmpty() {

    }

    public int length() {
        if (head.getData() == null) {
            return 0;
        }
        int i = 0;
        DuLNode currentNode = head.getNext();
        while (currentNode != head) {
            currentNode = currentNode.getNext();
            i++;
        }
        return i;
    }

}
