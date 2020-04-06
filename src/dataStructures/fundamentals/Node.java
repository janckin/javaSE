package dataStructures.fundamentals;

public class Node<T> {
    public Node<T> previous;
    public Node<T> next;
    public T data;

    public Node(Node<T> previous, Node<T> next, T data) {
        this.previous = previous;
        this.next = next;
        this.data = data;
    }

    public Node() {
        this.previous = null;
        this.next = null;
        this.data = null;
    }

    public Node(T data) {
        this.previous = null;
        this.next = null;
        this.data = data;
    }

    /**
     * definite the null node which is null or its data equaling null
     *
     * @param node the node to be tested
     * @return result
     */
    public static boolean isNullNode(Node<?> node) {
        if (node == null) {
            return true;
        }
        return node.data == null;
    }
}
