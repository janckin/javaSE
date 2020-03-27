package dataStructures.princeton.symbolTable;

import java.util.Objects;

public class Node<Key extends Comparable<Key>, Value> {
    public static final boolean RED = true;
    public static final boolean BLACK = false;

    public Node<Key, Value> right, left, parent;
    public Key key;
    public Value value;
    public int count;//count the subtree node number
    public boolean color;

    //remain the constructor in order to avoid the nullPointerException
    public Node() {
        this.color = BLACK;
    }

    public Node(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public Node(Key key, Value value, int count) {
        this.key = key;
        this.value = value;
        this.count = count;
    }

    public Node(Node<Key, Value> parent, Key key, Value value) {
        this.parent = parent;
        this.key = key;
        this.value = value;
    }

    public Node(Node<Key, Value> parent, Key key, Value value, int count, boolean color) {
        this.parent = parent;
        this.key = key;
        this.value = value;
        this.count = count;
        this.color = color;
    }

    public Node(Key key, Value value, int count, boolean color) {
        this.key = key;
        this.value = value;
        this.count = count;
        this.color = RED;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        sb.append("[");
        sb.append(color ? "red" : "black");
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Node)) return false;
        Node<?, ?> node = (Node<?, ?>) o;
        return count == node.count &&
                color == node.color &&
                key.equals(node.key) &&
                Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(right, left, parent, key, value, count, color);
    }
}
