package dataStructures.princeton.symbolTable;

import java.util.Stack;

/*
 * this red black tree use common method and is the 2-3-4 tree
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    public Node<Key, Value> root;

    public void rotateLeft(Node<Key, Value> x) {
        if (x == null || x.right == null) return;
        Node<Key, Value> right = x.right;
        Node<Key, Value> parent = x.parent;

        //alter x's grandson node to be its right node
        x.right = right.left;
        //refresh x's parent link
        x.parent = right;

        //refresh parent link belong to a node which is right's left child
        if (right.left != null) {
            right.left.parent = x;
        }

        //alter right node's left to be x
        right.left = x;
        //refresh right node's link
        right.parent = parent;


        //refresh parent node's link
        if (parent == null) {
            root = right;
        } else if (x.equals(parent.left)) {
            parent.left = right;
        } else if (x.equals(parent.right)) {
            parent.right = right;
        }
    }

    public void rotateRight(Node<Key, Value> x) {
        if (x == null || x.left == null) return;
        Node<Key, Value> left = x.left;
        Node<Key, Value> parent = x.parent;

        //alter x's grandson node to be its left node
        x.left = left.right;
        //refresh x's parent link
        x.parent = left;

        //refresh parent link belong to a node which is right's left child
        if (left.right != null) {
            left.right.parent = x;
        }

        //alter right node's left to be x
        left.right = x;
        //refresh right node's link
        left.parent = parent;

        //refresh parent node's link
        if (parent == null) {
            root = left;
        } else if (x.equals(parent.left)) {
            parent.left = left;
        } else if (x.equals(parent.right)) {
            parent.right = left;
        }
    }


    public boolean insert(Key key, Value value) {
        if (value == null || key == null) return false;
        insertNode(new Node<>(key, value));
        return true;
    }

    private void insertNode(Node<Key, Value> node) {
        if (root == null) {
            root = node;
            root.color = Node.BLACK;
            root.count = 0;
            return;
        }
        //find the parent for node
        Node<Key, Value> x = root, y = null;
        while (x != null) {
            y = x;
            int result = node.key.compareTo(x.key);
            if (result < 0) {
                x = x.left;
            } else if (result > 0) {
                x = x.right;
            } else {
                x.value = node.value;
                return;
            }
        }
        //update the parent link on node
        node.parent = y;

        //update the link on parent
        int result = node.key.compareTo(y.key);
        if (result < 0) {
            y.left = node;
        } else {
            y.right = node;
        }

        //set node as the leaf and red node
        node.color = Node.RED;
        node.count = 0;

        //fix up the relation of tree
        insertionFix(node);
    }

    private void insertionFix(Node<Key, Value> node) {
        if (node == null) return;
        //execute when node's parent is a red node
        while (node.parent != null && node.parent.color == Node.RED) {
            Node<Key, Value> parent = node.parent;
            Node<Key, Value> grandparent = parent.parent;
            if (parent.equals(grandparent.left)) {
                //parent is the left node of grandparent
                Node<Key, Value> parentBro = grandparent.right;
                //parent's brother is red node
                if (parentBro != null) {
                    if (parentBro.color == Node.RED) {
                        colorFlip(grandparent);
                        node = grandparent;
                        continue;
                    }
                }

                //node is the right node of its parent
                if (node.equals(parent.right)) {
                    rotateLeft(parent);
                    node = parent;
                    parent = node.parent;
                }

                //node is the left node of its parent
                if (node.equals(parent.left)) {
                    rotateRight(grandparent);
                }
                colorFlip(parent);
                node = parent;

            } else {
                //parent is right node of grandparent
                Node<Key, Value> parentBro = grandparent.left;
                //parent's brother is red node
                if (parentBro != null) {
                    if (parentBro.color == Node.RED) {
                        colorFlip(grandparent);
                        node = grandparent;
                        continue;
                    }
                }

                //node is the right node of its parent
                if (node.equals(parent.left)) {
                    rotateRight(parent);
                    node = parent;
                    parent = node.parent;
                }

                //node is the left node of its parent
                if (node.equals(parent.right)) {
                    rotateLeft(grandparent);
                }
                colorFlip(parent);
                node = parent;
            }
        }
        root.color = Node.BLACK;
    }

    private void colorFlip(Node<Key, Value> node) {
        if (node == null) return;
        node.color = Node.RED;
        if (node.left != null) node.left.color = Node.BLACK;
        if (node.right != null) node.right.color = Node.BLACK;
    }

    //main method of delete
    public void delete(Key key) {
        try {
            delete(root, key);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    /*

    private Node<Key, Value> delete(Node<Key, Value> node, Key key) {
        AtomicReference<Node<Key, Value>> atomicReference = new AtomicReference<>();
        delete(node, key, atomicReference);
        if (atomicReference.get() == null) {
            return root;
        } else {
            return atomicReference.get();
        }
    }*/

    //find the node and ready to delete
    private void delete(Node<Key, Value> node, Key key) throws IllegalArgumentException {
        if (isNullNode(node)) throw new IllegalArgumentException("to be deleted node is null");

        //find the target node
        Node<Key, Value> toBeDeletedNode = searchNodeByKey(node, key);

        //can not find the node
        if (isNullNode(toBeDeletedNode)) throw new IllegalArgumentException("no each key in the red black tree");


        if (isNullNode(toBeDeletedNode.right) || isNullNode(toBeDeletedNode.left)) {
            //if the node has a child or none child
            deleteOneChild(toBeDeletedNode);
        } else {
            //if the node has two children
            Node<Key, Value> nextToBeDeletedNode = treeMinimumNode(toBeDeletedNode.right);
            if (isNullNode(nextToBeDeletedNode))
                throw new IllegalArgumentException("the method of finding minimum has an error");

            toBeDeletedNode.value = nextToBeDeletedNode.value;
            toBeDeletedNode.key = nextToBeDeletedNode.key;
            delete(toBeDeletedNode.right, nextToBeDeletedNode.key);
        }
    }

    private Node<Key, Value> searchNodeByKey(Node<Key, Value> node, Key key) {
        while (node != null) {
            int result = key.compareTo(node.key);
            if (result == 0) {
                return node;
            } else if (result < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return new Node<>();
    }

    private void deleteOneChild(Node<Key, Value> toBeDeletedNode) {
        Node<Key, Value> child = isNullNode(toBeDeletedNode.left) ? toBeDeletedNode.right : toBeDeletedNode.left;

        if (isNullNode(child)) {
            //toBeDeletedNode is leaf, build a empty black to avoid null pointer
            child = new Node<>();
        }

        //replace toBeDeletedNode to its child
        Node<Key, Value> grandparent = toBeDeletedNode.parent;
        child.parent = grandparent;
        if (!isNullNode(grandparent)) {
            if (toBeDeletedNode.equals(grandparent.left)) {
                grandparent.left = child;
            } else {
                grandparent.right = child;
            }
        }

        if (isBlackNode(toBeDeletedNode)) {
            if (isBlackNode(child)) {
                //if toBeDeletedNode is black node, child is black node : child is the double black node
                DoubleBlackNode blackNode = new DoubleBlackNode(child);
                blackNode.balance();
                root.color = Node.BLACK;
            } else {
                //if toBeDeletedNode is black node, child is red: just change color of child
                child.color = Node.BLACK;
            }
        }
        //if toBeDeletedNode is red node, child is black node : child is the double black node
        //if toBeDeletedNode is red node, child is red: do nothing except exchange link
        transferToNull(child);
    }

    //double black node
    private class DoubleBlackNode {
        private Node<Key, Value> doubleBackNode, parent, brother;
        private boolean isLeftChild, isRoot;

        DoubleBlackNode(Node<Key, Value> toBeDeletedNode) {
            this.doubleBackNode = toBeDeletedNode;
            this.parent = toBeDeletedNode.parent;
            this.brother = findSiblingNode(toBeDeletedNode);
            this.isRoot = parent == null;
            if (parent != null) {
                this.isLeftChild = parent.left.equals(doubleBackNode);
            }
        }

        public void balance() {
            //double back node is the root
            if (isRoot) {
                balanceCase1(doubleBackNode);
                return;
            }
            // brother node is red node
            if (isRedNode(brother)) {
                balanceCase2(doubleBackNode);
                return;
            } else {
                //brother node is black
                if (isRedNode(parent)) {
                    balanceCase4(doubleBackNode);
                } else {
                    //parent and brother are both black
                    balanceCase3(doubleBackNode);
                    balanceCase5(doubleBackNode);
                }
            }
            balanceCase6(doubleBackNode);
        }

        //case 1, the double black node is the root
        public void balanceCase1(Node<Key, Value> doubleBackNode) {
            doubleBackNode.color = Node.BLACK;
            root = doubleBackNode;
        }

        //case 2, parent is black, brother is red, brother's two children are red
        public void balanceCase2(Node<Key, Value> doubleBackNode) {
            //rotation
            if (isLeftChild) {
                rotateLeft(parent);
            } else {
                rotateRight(parent);
            }
            //update the brother node since rotateLeft may create new brother
            this.brother = initialBrother(doubleBackNode);

            //change color
            parent.color = Node.RED;
            brother.color = Node.BLACK;

            balanceCase4(doubleBackNode);
        }

        //all the node is black
        public void balanceCase3(Node<Key, Value> doubleBackNode) {
            boolean leftIsBlack = isBlackNode(brother.left);
            boolean rightIsBlack = isBlackNode(brother.right);
            if (rightIsBlack && leftIsBlack) {
                brother.color = Node.RED;

                //doubleBackNode is nullNode, set null
                transferToNull(doubleBackNode);

                //update and continue;
                this.doubleBackNode = parent;
                this.brother = findSiblingNode(this.doubleBackNode);
                this.parent = this.doubleBackNode.parent;
                this.isRoot = this.parent == null;
                if (!isRoot) {
                    this.isLeftChild = parent.left.equals(this.doubleBackNode);
                }
                balance();
            }
        }


        //parent is red, brother is black and the children of brother is black or null
        public void balanceCase4(Node<Key, Value> doubleBackNode) {
            boolean leftIsBlack = isBlackNode(brother.left);
            boolean rightIsBlack = isBlackNode(brother.right);
            if (rightIsBlack && leftIsBlack) {
                parent.color = Node.BLACK;
                brother.color = Node.RED;
            }
        }

        //parent is red, brother is black and the left children of brother is red
        public void balanceCase5(Node<Key, Value> doubleBackNode) {
            if (isRoot) return;
            Node<Key, Value> leftGrandson = brother.left;
            Node<Key, Value> rightGrandson = brother.right;
            boolean leftGrandsonIsBlack = isBlackNode(leftGrandson);
            boolean rightGrandsonIsBlack = isBlackNode(rightGrandson);
            boolean boolean1 = !isSameColor(leftGrandson, parent) && !leftGrandsonIsBlack && rightGrandsonIsBlack;
            boolean boolean2 = !isSameColor(leftGrandson, parent) && leftGrandsonIsBlack && !rightGrandsonIsBlack;

            if (boolean1 || boolean2) {
                if (boolean1) {
                    rotateRight(brother);
                } else {
                    rotateLeft(brother);
                }

                brother.color = Node.RED;
                brother.parent.color = Node.BLACK;
                this.brother = brother.parent;

                balanceCase6(doubleBackNode);
            }
        }

        //parent can be either red or black, if the double black node is its left son, its grandson which is the left node of root's right node should follow it
        public void balanceCase6(Node<Key, Value> doubleBackNode) {
            Node<Key, Value> leftGrandson = brother.left;
            Node<Key, Value> rightGrandson = brother.right;
            if (isSameColor(leftGrandson, parent) && !isBlackNode(rightGrandson)) {
                rotateLeft(parent);
                rightGrandson.color = Node.BLACK;
            } else if (isSameColor(rightGrandson, parent) && !isBlackNode(leftGrandson)) {
                rotateLeft(parent);
                leftGrandson.color = Node.BLACK;
            }
        }

        private Node<Key, Value> initialBrother(Node<Key, Value> doubleBackNode) {
            Node<Key, Value> brother = findSiblingNode(doubleBackNode);
            if (isNullNode(brother)) throw new IllegalArgumentException("double black node 's brother can't be null");
            return brother;
        }

    }

    private boolean isBlackNode(Node<Key, Value> node) {
        return node == null || node.color == Node.BLACK;
    }

    private boolean isRedNode(Node<Key, Value> node) {
        if (node == null) return false;
        return node.color == Node.RED;
    }

    private boolean isSameColor(Node<Key, Value> node1, Node<Key, Value> node2) {
        return isBlackNode(node1) == isBlackNode(node2);
    }

    //find the brother node
    private Node<Key, Value> findSiblingNode(Node<Key, Value> node) {
        if (node == null) {
            return null;
        }
        Node<Key, Value> parent = node.parent;
        //node is the root node
        if (parent == null) {
            root = node;
            return null;
        }
        boolean isLeftChildren = parent.left.equals(node);
        if (isLeftChildren) {
            return parent.right;
        } else {
            return parent.left;
        }
    }

    /**
     * find the minimum key for node x
     *
     * @param x the root node
     * @return the minimum and not null node
     */
    private Node<Key, Value> treeMinimumNode(Node<Key, Value> x) {
        if (isNullNode(x)) return null;
        while (x.left != null) {
            x = x.left;
        }
        return x;
    }

    private boolean isNullNode(Node<Key, Value> x) {
        if (isNull(x)) return true;
        return x.key == null;
    }

    private boolean isNull(Node<Key, Value> x) {
        return x == null;
    }

    private void transferToNull(Node<Key, Value> node) {
        //change child to null
        if (isNullNode(node)) {
            Node<Key, Value> parent = node.parent;
            if (!isNullNode(parent)) {
                if (node.equals(parent.left)) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        }
    }

    @Override
    public String toString() {
        Stack<Node<Key, Value>> stack = new Stack<>();
        Node<Key, Value> current = root;
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

}
