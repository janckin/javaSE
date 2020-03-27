package dataStructures.princeton.symbolTable;

import java.util.Stack;

/*
 * red-black tree implements 2-3 tree
 */
public class RBT<Key extends Comparable<Key>, Value> {
    private final boolean RED = true;
    private final boolean BLACK = false;
    private Node root;


    private class Node {
        Key key;
        Value value;
        Node left, right;
        boolean color;//color of link from parent
        int count;

        Node(Key key, Value value, int count, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.count = count;
        }

        @Override
        public String toString() {
            String c = color ? "red" : "black";
            return value + "[" + c + "]";
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }

    /**
     * change parent's right to left
     * p.s:
     * question: the grandparent node no need to change?
     * answer: is unnecessary to change because just change all the link
     * it means when use rotateLeft, use the Node node = rotateLeft(node);
     *
     * @param parent parent node
     * @return
     */
    public Node rotateLeft(Node parent) {
        Node rightNode = parent.right;

        //set parent's right node to be child's left
        parent.right = rightNode.left;

        //set child right node to be parent
        rightNode.left = parent;

        //change the color
        rightNode.color = parent.color;
        parent.color = RED;

        //change count
        rightNode.count = parent.count;
        parent.count = 1 + size(parent.left) + size(parent.right);
        return rightNode;
    }

    /**
     * change parent left node to right
     *
     * @param parent
     * @return
     */
    public Node rotateRight(Node parent) {
        Node leftNode = parent.left;

        //set parent's right node to be child's left
        parent.left = leftNode.right;

        //set child right node to be parent
        leftNode.right = parent;

        //change the color
        leftNode.color = parent.color;
        parent.color = RED;

        //change count
        leftNode.count = parent.count;
        parent.count = 1 + size(parent.left) + size(parent.right);
        return leftNode;
    }

    /**
     * change the color of root
     * and it's child
     *
     * @param h the root node
     */
    void flipColor(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, 1, RED);
        int compare = key.compareTo(node.key);
        if (compare == 0) {
            node.value = value;
        } else if (compare > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.left = put(node.left, key, value);
        }

        if (!isRed(node.left) && isRed(node.right)) node = rotateLeft(node);

        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);

        if (isRed(node.left) && isRed(node.right)) flipColor(node);

        node.count = size(node.left) + size(node.right) + 1;

        return node;
    }

    @Override
    public String toString() {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        StringBuilder sb = new StringBuilder();
        stack.push(current);
        while (current != null && !stack.isEmpty()) {

            current = stack.pop();

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
            sb.append(current).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        char[] chars = {'s', 'e', 'a', 'r', 'c', 'h', 'x', 'm', 'p', 'l'};
        char[] chars2 = {'a', 'c', 'e', 'h', 'l', 'm', 'p', 'r', 's', 'x'};
        RBT<Character, Character> brt1 = new RBT<>();
        RBT<Character, Character> brt2 = new RBT<>();
        for (int i = 0; i < chars.length; i++) {
            brt1.put(chars[i], chars[i]);
            brt2.put(chars2[i], chars2[i]);
        }
        System.out.println(brt1.toString());
        System.out.println(brt2.toString());
    }
}
