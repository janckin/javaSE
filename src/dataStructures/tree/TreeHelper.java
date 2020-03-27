package dataStructures.tree;

import java.util.Stack;

public class TreeHelper<T> {


    private Node<T> root;

    //StringBuilder ret_str;

    public void insert(Node<T> root) {
        this.root = root;
    }

    ;

    public boolean remove() {
        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }


    public void printTree() {
        if (isEmpty()) {
            throw new NullPointerException();
        }

        System.out.println("start print>>>>");
        //midTraversal();
        //postOrder();
        //System.out.println("start midOrderByRec print>>>>");
        //preOrderTraverse();
    }

    /**
     * @author lsy
     */
    private void preOrderTraverse() {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> current = root;
        stack.push(current);
        while (current != null && !stack.isEmpty()) {

            current = stack.pop();

            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
            System.out.print(current.getContext() + " ");
        }
    }

    /**
     * @author lsy
     */
    private void inOrderTraverse() {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> current = root;
        while (!stack.isEmpty() || current != null) {
            //get the deepest left node
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }

            //get the top element of stack
            if (current == null) {
                current = stack.pop();
            }

            //get the context
            System.out.print(current.getContext() + " ");

            //ready for the right tree
            if (current.getRight() == null) {
                current = null;
            } else {
                //stack.push(current);
                current = current.getRight();
            }
        }

    }

    /**
     * postOrder of a tree use two while
     *
     * @author lsy
     */
    private void postOrder() {
        Stack<MyBinaryNode<T>> stack = new Stack<>();

        MyBinaryNode<T> current = new MyBinaryNode<>(root);

        do {

            //become the deepest left
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }

            /**
             * current is null: it means a lead of tree is end
             * current is not null: it means current is a right node
             */
            if (current == null) {
                current = stack.pop();
            }

            /**
             * current has right node:
             *    1.push current node back to stack
             *    2.record this node
             *    3.go into right node
             *
             * current has no right node or has been read(because some nodes are push back to stack):
             *    1.out put the context
             *    2.set current as null so that pop the top element of the stack
             */
            if (current.getRight() == null || current.hasRead()) {
                System.out.print(current.getContext() + " ");
                //stop the loop of finding left tree
                current = null;
            } else {
                //push back the one and record
                stack.push(current);
                current.setRead();

                //turn to right tree
                current = current.getRight();
            }
        } while (!stack.isEmpty());

    }

    /**
     * just use O(N) to finish back
     *
     * @auther Zhenqin Hong
     */
    private void postOrderAdanced() {
        Stack<MyBinaryNode<T>> stack = new Stack<>();
        MyBinaryNode<T> current = new MyBinaryNode<>(root);
        do {
            if (current != null) {
                current.setRead();
                stack.push(current);
                current = current.getLeft();
            } else {
                current = stack.peek();
                if (current.hasRead()) {
                    current.noRead();
                    current = current.getRight();
                } else {
                    System.out.print(current.getContext() + " ");
                    stack.pop();
                    current = null;
                }
            }
        } while (!stack.isEmpty());
    }

    /**
     * recursion to resolve problem
     *
     * @auther lsy
     */
    private void postOrderByRec() {
        postOrderNode(root);
    }

    private void midOrderByRec() {
        midOrderNode(root);
    }

    private void midOrderNode(Node<T> node) {
        if (node == null) {
            return;
        }
        midOrderNode(node.getLeft());
        System.out.print(node.getContext() + " ");
        midOrderNode(node.getRight());
    }

    private void postOrderNode(Node node) {
        if (node == null) {
            return;
        }
        postOrderNode(node.getLeft());
        postOrderNode(node.getRight());
        System.out.print(node.getContext() + " ");
    }
}
