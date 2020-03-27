package dataStructures.tree;


import java.util.Objects;

/**
 * add the variable on read
 *
 * @param <T>
 */
public class MyBinaryNode<T> extends Node<T> {
    private boolean read;

    public MyBinaryNode() {
        super();
        this.read = false;
    }

    public MyBinaryNode(Node<T> father) {
        super.left = father.left;
        super.right = father.right;
        super.context = father.context;
        this.read = false;
    }

    public MyBinaryNode getLeft() {
        if (super.left == null) {
            return null;
        }
        return new MyBinaryNode(super.left);
    }

    public MyBinaryNode getRight() {
        if (super.right == null) {
            return null;
        }
        return new MyBinaryNode(super.right);
    }

    public static Node parseNode(MyBinaryNode binaryNode) {
        return new Node(binaryNode.context, binaryNode.left, binaryNode.right);
    }

    public void setRead() {
        this.read = true;
    }

    public void noRead() {
        this.read = false;
    }

    public boolean hasRead() {
        return this.read;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyBinaryNode)) return false;
        if (!super.equals(o)) return false;
        MyBinaryNode<?> that = (MyBinaryNode<?>) o;
        return read == that.read;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), read);
    }
}
