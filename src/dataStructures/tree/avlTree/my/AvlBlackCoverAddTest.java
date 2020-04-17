package dataStructures.tree.avlTree.my;

public class AvlBlackCoverAddTest {

    public static void testLeftRotation() {
        AvlBlackCover.Node<Integer> root1 = new AvlBlackCover.Node<>(7);
        root1.right = new AvlBlackCover.Node<>(8);
        root1.right.right = new AvlBlackCover.Node<>(9);
        AvlBlackCover<Integer> tree1 = new AvlBlackCover<>(root1);
        tree1.setRoot(tree1.leftRotation(root1));
        assert ("8 7 9 ".equals(tree1.toString()));
        System.out.println(">> pass LeftRotation >>");
    }

    public static void testRightRotation() {
        //test rightRotation
        AvlBlackCover.Node<Integer> root1 = new AvlBlackCover.Node<>(7);
        root1.left = new AvlBlackCover.Node<>(6);
        root1.left.left = new AvlBlackCover.Node<>(5);
        AvlBlackCover<Integer> tree1 = new AvlBlackCover<>(root1);
        tree1.setRoot(tree1.rightRotation(root1));
        assert ("6 5 7 ".equals(tree1.toString()));
        System.out.println(">> pass rightRotation >>");
    }

    public static void testISharpBalanceInRight() {
        Integer[] arr = {7, 8, 9};
        AvlBlackCover<Integer> tree1 = new AvlBlackCover<>(arr);
        assert ("8 7 9 ".equals(tree1.toString()));
        System.out.println(">> pass testISharpBalanceInRight >>");
    }

    public static void testISharpBalanceInLeft() {
        Integer[] arr = {7, 6, 5};
        AvlBlackCover<Integer> tree1 = new AvlBlackCover<>(arr);
        assert ("6 5 7 ".equals(tree1.toString()));
        System.out.println(">> pass testISharpBalanceInLeft >>");
    }

    public static void testLSharpBalanceInRight() {
        Integer[] arr = {7, 9, 8};
        AvlBlackCover<Integer> tree1 = new AvlBlackCover<>(arr);
        assert ("8 7 9 ".equals(tree1.toString()));
        System.out.println(">> pass testLSharpBalanceInRight >>");
    }

    public static void testLSharpBalanceInLeft() {
        Integer[] arr = {7, 5, 6};
        AvlBlackCover<Integer> tree1 = new AvlBlackCover<>(arr);
        assert ("6 5 7 ".equals(tree1.toString()));
        System.out.println(">> pass testLSharpBalanceInLeft >>");
    }

    public static void testAdd() {
        Integer[] arr = {7, 8, 9, 10, 11, 12};
        AvlBlackCover<Integer> tree1 = new AvlBlackCover<>(arr);
        assert ("10 8 7 9 11 12 ".equals(tree1.toString()));
        System.out.println(">> pass testAdd >>");
    }


    public static void main(String[] args) {
        testLeftRotation();
        testRightRotation();
        testISharpBalanceInRight();
        testISharpBalanceInLeft();
        testLSharpBalanceInRight();
        testLSharpBalanceInLeft();
        testAdd();
    }
}
