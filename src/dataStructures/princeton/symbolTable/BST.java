package dataStructures.princeton.symbolTable;

/*
this class is the balanced search tree
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root;

    /**
     * use recursive code so that the code become concise but tricky
     *
     * @param key   key
     * @param value value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node<Key, Value> put(Node<Key, Value> node, Key key, Value value) {
        if (node == null) return new Node<>(key, value);
        int compare = key.compareTo(node.key);
        if (compare == 0) {
            node.value = value;
        } else if (compare > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.left = put(node.left, key, value);
        }
        return node;
    }

    public Value get(Key key) {
        Node<Key, Value> current = root;
        while (current != null) {
            int result = key.compareTo(current.key);
            if (result == 0) {
                return current.value;
            } else if (result > 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return null;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node<Key, Value> deleteMin(Node<Key, Value> node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.count = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node<Key, Value> delete(Node<Key, Value> node, Key key) {
        if (node == null) return null;
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            node.right = delete(node.right, key);
        } else if (compare < 0) {
            node.left = delete(node.left, key);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node<Key, Value> temp = node;
            node = min(node.right);
            node.left = temp.left;
            node.right = deleteMin(temp.right);
        }
        node.count = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key min() {
        return min(root).key;
    }

    private Node<Key, Value> min(Node<Key, Value> node) {
        Node<Key, Value> current = node;
        while (current != null) {
            Node<Key, Value> left = current.left;
            if (left == null) {
                return current;
            } else {
                current = left;
            }
        }
        return null;
    }

    private int size(Node<Key, Value> node) {
        if (node == null) return 0;
        return node.count;
    }

    public int size() {
        return root.count;
    }

    public Iterable<Key> iterator() {
        return null;
    }
}
