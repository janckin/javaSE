package dataStructures.tree.avlTree;

public class AvlTreeUtils<T> {
    private AvlTreeNode<T> root;

    public void setRoot(AvlTreeNode<T> root) {
        this.root = root;
    }

    public AvlTreeNode<T> insert(T target, AvlTreeNode<T> node) {
        //it means target in on a leaf
        if (node == null) {
            return new AvlTreeNode<T>(target, null, null);
        }

        int compare = root.compareTo(target);

        if (compare < 0) {
            node.left = insert(target, node.left);
        } else if (compare > 0) {
            node.right = insert(target, node.right);
        }

        return balance(node);
    }

    private static int ALLOWED_IMBALANCE = 1;

    public AvlTreeNode<T> balance(AvlTreeNode<T> node) {

        if (node == null) {
            return node;
        }

        AvlTreeNode<T> left_node = node.left;
        AvlTreeNode<T> right_node = node.left;
        //left tree is deeper than right tree
        if (left_node.height - right_node.height > ALLOWED_IMBALANCE) {

            // decide how to turn the left children
            if (left_node.left.height >= left_node.right.height) {
                node = rotateWithLeftChild(node);
            } else {
                node = doubleWithLeftChild(node);
            }

            //right tree is deeper than right tree
        } else if (right_node.height - left_node.height > ALLOWED_IMBALANCE) {

            if (right_node.right.height >= right_node.right.left.height) {
                node = rotateWithRightChild(node);
            } else {
                node = doubleWithRightChild(node);
            }

        }
        return null;
    }

    /**
     * this method is used to make left avltree turning once
     *
     * @param node the root of left tree
     * @return
     */
    public AvlTreeNode<T> rotateWithLeftChild(AvlTreeNode<T> node) {
        //the left child tree
        AvlTreeNode<T> new_node = node.left;

        //set the node left to become new_node's right.
        //or node.left = node.left.right
        node.left = new_node.right;

        //make the new_node become the new root
        new_node.right = node;

        //change their height
        //because node is child tree, so it's height in the maximum of its child trees
        node.height = Math.max(node.left.height, node.right.height) + 1;
        //new_node height is the maximum on its child trees too, but, node is its right child tree at same time
        new_node.height = Math.max(new_node.left.height, node.height) + 1;

        return new_node;
    }

    /**
     * this method is used to make left avltree turning once
     *
     * @param node the root of right tree
     * @return
     */
    public AvlTreeNode<T> rotateWithRightChild(AvlTreeNode<T> node) {
        AvlTreeNode<T> new_node = node.right;

        node.right = new_node.left;

        new_node.left = node;

        node.height = Math.max(node.left.height, node.right.height) + 1;
        new_node.height = Math.max(new_node.left.height, node.height) + 1;

        return new_node;
    }

    /**
     * this method is used to make left avltree turning double
     *
     * @param node
     * @return
     */
    public AvlTreeNode<T> doubleWithLeftChild(AvlTreeNode<T> node) {
        //firstly let the left child tree become balance
        node.left = rotateWithLeftChild(node.left);
        //turn the right tree into the balance;
        node = rotateWithRightChild(node);
        return node;
    }

    /**
     * this method is used to make left avltree turning double
     *
     * @param node
     * @return
     */
    public AvlTreeNode<T> doubleWithRightChild(AvlTreeNode<T> node) {
        //firstly let the left child tree become balance
        node.right = rotateWithRightChild(node.right);
        //turn the right tree into the balance;
        node = rotateWithLeftChild(node);
        return node;
    }
}
