package dataStructures.tree;

public class BinarySearchTree<T> {
    private BinarySearchNode<T> root;


    public BinarySearchNode<T> getRoot() {
        return root;
    }

    public void insert(BinarySearchNode<T> root) {
        this.root = root;
    }

    public BinarySearchNode insertByRec(BinarySearchNode<T> target, BinarySearchNode<T> node) {

        if (node == null) {
            return target;
        }

        int compare = target.compareTo(node);

        if (compare < 0) {
            node.left = insertByRec(target, node.getLeft());
        } else {
            //need to go to the right node
            node.right = insertByRec(target, node.getRight());
        }

        return target;
    }

    /**
     * remove a node in a tree
     * if
     *
     * @param target the target node
     */
    public void remove(BinarySearchNode<T> target) {
        removeByRec(target, root);
    }

    /**
     * use recursion to replace the node once the node replace successfully return target
     *
     * @param target the target node
     * @param node   the head of child tree
     * @return the node with new right or left child tree
     */
    private BinarySearchNode<T> removeByRec(BinarySearchNode<T> target, BinarySearchNode<T> node) {
        if (node == null) {
            return null;
        }
        int compare = target.compareTo(node);

        if (compare < 0) {
            node.left = removeByRec(target, node.getLeft());
        } else if (compare > 0) {
            node.right = removeByRec(target, node.getRight());
        } else {
            //find the node
            if (node.left != null && node.right != null) {
                /**
                 * when the node has right and left node:
                 * firstly:
                 *  find the minimum node in right,
                 *  and make it to replace the target
                 *
                 * secondly:
                 *  remove this minimum node;
                 *  if this minimum node has right and left node, recurse the remove method
                 *
                 */
                BinarySearchNode<T> minNode = findMin(node.getRight());
                T context = minNode.context;
                node.context = context;

                node.right = removeByRec(minNode, node.getRight());

            } else {
                /**
                 * when the target node only has a left or right node:
                 * just replace its node and end
                 */
                if (node.left == null) {
                    node = node.getRight();
                } else {
                    node = node.getLeft();
                }
            }
        }
        return node;
    }

    /**
     * find target in tree
     *
     * @param target node
     * @return is it contain
     */
    public boolean contain(BinarySearchNode<T> target) {
        return containByRec(target, root);
    }

    /**
     * find target in an other tree
     *
     * @param target new node
     * @param head   the root of tree
     * @return the result of exist
     */
    public boolean containByRec(BinarySearchNode<T> target, BinarySearchNode<T> head) {
        /*
         * because searchNode has its own order,
         * therefore, when recursion is in the deepest of tree
         * the head will be null.
         */
        if (head == null) {
            return false;
        }

        int compare = target.compareTo(head);

        /*
         * <0 : need to go into left node
         * >0: need to go into right node
         * =0: find the node
         */
        if (compare < 0) {
            return containByRec(target, head.getLeft());
        } else if (compare > 0) {
            return containByRec(target, head.getRight());
        } else {
            return true;
        }

    }

    /**
     * find the minimum node in tree
     *
     * @return the minimum context node
     */
    public BinarySearchNode<T> findMin() {
        return findMin(root);
    }

    private BinarySearchNode<T> findMin(BinarySearchNode<T> node) {
        while (node != null) {
            if (node.getLeft() == null) {
                return node;
            } else {
                node = node.getLeft();
            }

        }
        return null;
    }

    /**
     * find the maximum node in tree
     *
     * @return the maximum context node
     */
    public BinarySearchNode<T> findMax() {
        return findMax(root);
    }

    private BinarySearchNode<T> findMax(BinarySearchNode<T> node) {
        while (node != null) {
            if (node.getRight() == null) {
                return node;
            } else {
                node = node.getRight();
            }
        }
        return null;
    }

}
