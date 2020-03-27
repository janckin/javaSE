package dataStructures.tree;

import java.util.Objects;

public class BinarySearchNode<T> extends Node<T> implements Comparable<T> {

    public BinarySearchNode(T context) {
        super.context = context;
    }

    public BinarySearchNode(Node<T> node) {
        super.left = node.left;
        super.right = node.right;
        super.context = node.context;
    }


    public BinarySearchNode getLeft() {
        if (super.left == null) {
            return null;
        }
        return new BinarySearchNode(super.left);
    }

    public BinarySearchNode getRight() {
        if (super.right == null) {
            return null;
        }
        return new BinarySearchNode(super.right);
    }

    public static Node parseNode(BinarySearchNode binarySearchNode) {
        return new Node(binarySearchNode.context, binarySearchNode.left, binarySearchNode.right);
    }

    /**
     * compare the different between node
     *
     * @param node
     * @return
     */
    public int compareTo(BinarySearchNode<T> node) {
        return compareTo(node.getContext());
    }

    @Override
    public int compareTo(T o) {
        if (o instanceof Integer && super.context instanceof Integer) {
            Integer original = (Integer) super.context;
            Integer target = (Integer) o;
            return Integer.compare(original, target);
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Node) {
            return super.equals(o);
        }
        if (!(o instanceof BinarySearchNode)) return false;
        BinarySearchNode<?> node = (BinarySearchNode<?>) o;
        return Objects.equals(context, node.context);
    }
}
