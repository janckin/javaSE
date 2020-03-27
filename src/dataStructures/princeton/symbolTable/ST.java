package dataStructures.princeton.symbolTable;

/*
 * this class is describe the symbol table
 */
public class ST<Key extends Comparable<Key>, Value> {
    //private int CAPACITY = 10;
    private int size;
    private Key[] keys;
    private Value[] vals;
    private Node<Key, Value> root;//this value upgrade the keys array,use binary tree

    /**
     * use the link list data structure
     *
     * @param key key
     * @param val value
     */
    void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node<Key, Value> put(Node<Key, Value> node, Key key, Value val) {
        if (node == null) return new Node<>(key, val);
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = val;
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.left = put(node.left, key, val);
        }
        node.count = size(node.left) + size(node.right);
        return node;
    }

    Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < size && key.compareTo(keys[i]) == 0) {
            return vals[i];
        }
        return null;
    }

    /**
     * use binary search
     */
    private int rank(Key key) {
        int lo, hi, mi;
        lo = 0;
        hi = size - 1;
        while (lo < hi) {
            mi = (hi - lo) / 2;
            int result = key.compareTo(keys[mi]);
            if (result > 0) {
                lo = mi;
            } else if (result < 0) {
                hi = mi;
            } else {
                return mi;
            }
        }
        return lo;
    }

    /**
     * rank under the new data structure
     *
     * @param key the key need to match
     * @return
     */
    public int newRank(Key key) {
        return newRank(key, root);
    }

    private int newRank(Key key, Node<Key, Value> node) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return size(node);
        } else if (cmp > 0) {
            return newRank(key, node.right) + size(node.left) + 1;
        } else {
            return newRank(key, node.left);
        }
    }


    void deleteOld(Key key) {
        put(key, null);
        size--;
    }

    boolean contains(Key key) {
        return get(key) != null;
    }

    boolean isEmpty() {
        return size() == 0;
    }

    int getSize() {
        return size;
    }

    Iterable<Key> keys() {
        return null;
    }

    /**
     * methods bases on order of the key
     */
    Key min() {
        return null;
    }

    Key max() {
        return null;
    }

    /**
     * find the nearly value which is smaller than key
     *
     * @param key the target key
     * @return
     */
    Key floor(Key key) {
        Node<Key, Value> node = floor(root, key);
        if (node == null) return null;
        return node.key;
    }

    private Node<Key, Value> floor(Node<Key, Value> node, Key key) {
        if (node == null) return null;
        int compare = key.compareTo(node.key);
        if (compare == 0) return node;
        if (compare < 0) return floor(node.left, key);
        Node<Key, Value> right = floor(node.right, key);
        if (right == null) {
            return node;
        } else {
            return right;
        }

    }


    Key ceil(Key key) {
        return null;
    }

    Key select(int k) {
        return null;
    }

    void deleteMax() {

    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node<Key, Value> deleteMin(Node<Key, Value> node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node<Key, Value> delete(Node<Key, Value> node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;

            Node<Key, Value> t = node;

            node = min(t.right);

            node.right = deleteMin(node.right);
            node.left = t.left;
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            node.left = delete(node.left, key);
        }
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    private Node<Key, Value> min(Node<Key, Value> node) {
        if (node == null) return new Node<>(null, null);
        Node<Key, Value> current = node;
        while (true) {
            if (current.left == null) {
                return current;
            }
            current = current.left;
        }
    }

    /**
     * use the link list data structure
     *
     * @return
     */
    public int size() {
        return size(root);
    }

    private int size(Node<Key, Value> node) {
        return node.count;
    }

    Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    /*private void resize(int capacity) {
        if (capacity < keys.length) {
            return;
        }
        Object[] temp = Arrays.copyOf(keys, keys.length);
        keys = new Object[capacity];
        for (int i = 0; i < temp.length; i++) {
            keys[i] = temp[i];
        }
    }*/
    public static void main(String[] args) {
        int i = Integer.parseInt("1304F", 16);
        char[] chars = Character.toChars(i);
        String s = new String(chars);
        System.out.println(s);
    }


}
