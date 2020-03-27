package dataStructures.tree.avlTree;

/**
 * if need to develop in ee, use getter setter
 *
 * @param <T>
 */
public class AvlTreeNode<T> implements Comparable {
    public T context = null;
    public AvlTreeNode<T> left = null;
    public AvlTreeNode<T> right = null;
    public int height = 0;

    public AvlTreeNode() {

    }

    public AvlTreeNode(T Context, AvlTreeNode left, AvlTreeNode right, int height) {
        this.context = context;
        this.left = left;
        this.right = right;
        this.height = height;
    }

    public AvlTreeNode(T Context, AvlTreeNode left, AvlTreeNode right) {
        this.context = context;
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Integer && context instanceof Integer) {
            return ((Integer) o).compareTo((Integer) context);
        }
        return 0;
    }
}
