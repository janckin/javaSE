package dataStructures.tree.avlTree.my;


import java.util.Stack;

public class AvlBlackCover<T extends Comparable<T>> {
    private Node<T> root;
    private final int GAP;/* the different of left and right */

    public AvlBlackCover(Node<T> root) {
        this.GAP = 1;
        this.root = root;
    }

    public AvlBlackCover(T[] a) {
        this.GAP = 1;
        for (T t : a) {
            add(t);
        }
    }

    public Node<T> leftRotation(Node<T> root) {
        Node<T> newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.height = refreshHeight(root);
        newRoot.height = refreshHeight(newRoot);
        return newRoot;
    }

    public Node<T> rightRotation(Node<T> root) {
        Node<T> newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.height = refreshHeight(root);
        newRoot.height = refreshHeight(newRoot);
        return newRoot;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (root == null) {
            root = newNode;
        } else {
            root = add(root, newNode);
        }
    }

    /**
     * this method could not add the same node
     *
     * @param node    the cursor node
     * @param newNode the new node
     * @return the new node or existed node
     */

    public Node<T> add(Node<T> node, Node<T> newNode) {
        //find the place for newNode
        if (isNullNode(node)) return newNode;

        //search place for newNode
        if (newNode.data.compareTo(node.data) > 0) {
            node.right = add(node.right, newNode);
        } else if (newNode.data.compareTo(node.data) < 0) {
            node.left = add(node.left, newNode);
        }

        //balance the node
        int diff = getHeight(node.left) - getHeight(node.right);
        if (Math.abs(diff) > GAP) {
            node = balance(node);
        } else {
            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
        return node;
    }


    private Node<T> balance(Node<T> node) {
        int gap = getHeight(node.left) - getHeight(node.right);
        if (gap > 0) {
            //in left
            if (isNullNode(node.left)) throw new IllegalArgumentException("balance error: node's left child is null");
            Node<T> left = node.left;
            int gap2 = getHeight(left.left) - getHeight(left.right);
            if (gap2 > 0) {
                //child's height is bigger than right
                node = iSharpBalanceInLeft(node);
            } else {
                node = LSharpBalanceInLeft(node);
            }

        } else {
            //in right
            if (isNullNode(node.right)) throw new IllegalArgumentException("balance error: node's right child is null");
            Node<T> right = node.right;
            int gap2 = getHeight(right.left) - getHeight(right.right);
            if (gap2 > 0) {
                //left child's height is bigger than right
                node = LSharpBalanceInRight(node);
            } else {
                node = iSharpBalanceInRight(node);
            }
        }
        return node;
    }

    private Node<T> LSharpBalanceInRight(Node<T> node) {
        if (isNullNode(node) || isNullNode(node.right))
            throw new IllegalArgumentException("LSharpBalanceInRight error: node's right child is null");
        node.right = rightRotation(node.right);
        node = leftRotation(node);
        return node;
    }

    private Node<T> LSharpBalanceInLeft(Node<T> node) {
        if (isNullNode(node) || isNullNode(node.left))
            throw new IllegalArgumentException("LSharpBalanceInRight error: node's left child is null");
        node.left = leftRotation(node.left);
        node = rightRotation(node);
        return node;
    }

    private Node<T> iSharpBalanceInRight(Node<T> node) {
        if (isNullNode(node) || isNullNode(node.right))
            throw new IllegalArgumentException("iSharpBalanceInRight error: node's right child is null");
        node = leftRotation(node);
        return node;
    }

    private Node<T> iSharpBalanceInLeft(Node<T> node) {
        if (isNullNode(node) || isNullNode(node.left))
            throw new IllegalArgumentException("iSharpBalanceInRight error: node's left child is null");
        node = rightRotation(node);
        return node;
    }


    private boolean isNullNode(Node<T> node) {
        if (node == null) return true;
        return node.data == null;
    }

    /**
     * get the height of a node
     *
     * @param node a node
     * @return the height number
     */
    private int getHeight(Node<T> node) {
        if (isNullNode(node)) {
            return 0;
        }
        return node.height;
    }

    /**
     * get the new height of a node
     *
     * @param node a node
     * @return new height
     */
    private int refreshHeight(Node<T> node) {
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Stack<Node<T>> stack = new Stack<>();
        Node<T> current = this.root;
        stack.push(current);
        while (current != null && !stack.isEmpty()) {
            current = stack.pop();
            if (!isNullNode(current.right)) {
                stack.push(current.right);
            }
            if (!isNullNode(current.left)) {
                stack.push(current.left);
            }
            sb.append(current.data).append(" ");
        }
        return sb.toString();
    }


    //static because of test
    public static class Node<T extends Comparable<T>> {
        public T data;
        public Node<T> left;
        public Node<T> right;
        public int height;

        public Node(T data) {
            this.data = data;
            this.height = 1;
        }
    }
}
