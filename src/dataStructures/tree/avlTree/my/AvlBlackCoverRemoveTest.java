package dataStructures.tree.avlTree.my;

public class AvlBlackCoverRemoveTest {
    public static void deleteLeaf() {
        AvlBlackCover<Integer> tree = init();
        tree.remove(7);
        String treePreTraver = tree.checkedTreeWithHeight();
        assert ("[8 (h: 4)] [4 (h: 3)] [1 (h: 1)] [6 (h: 2)] [5 (h: 1)] [14 (h: 3)] [13 (h: 1)] [17 (h: 2)] [20 (h: 1)] ".equals(treePreTraver));
        System.out.println(">> test deleteLeaf pass! >>");
    }

    public static void deleteHasLeftTreeNoRight() {
        AvlBlackCover<Integer> tree = init();
        tree.remove(5);
        String treePreTraver1 = tree.checkedTreeWithHeight();
        assert ("[8 (h: 4)] [6 (h: 3)] [4 (h: 2)] [1 (h: 1)] [7 (h: 1)] [14 (h: 3)] [13 (h: 1)] [17 (h: 2)] [20 (h: 1)] ".equals(treePreTraver1));

        tree.remove(4);
        String treePreTraver = tree.checkedTreeWithHeight();
        assert ("[8 (h: 4)] [6 (h: 2)] [1 (h: 1)] [7 (h: 1)] [14 (h: 3)] [13 (h: 1)] [17 (h: 2)] [20 (h: 1)] ".equals(treePreTraver));
        System.out.println(">> test deleteHasLeftTreeNoRight pass! >>");
    }


    public static void deleteARightNoLeft() {
        AvlBlackCover<Integer> tree = init();
        tree.remove(17);
        String treePreTraver = tree.checkedTreeWithHeight();
        assert ("[8 (h: 4)] [6 (h: 3)] [4 (h: 2)] [1 (h: 1)] [5 (h: 1)] [7 (h: 1)] [14 (h: 2)] [13 (h: 1)] [20 (h: 1)] ".equals(treePreTraver));
        System.out.println(">> test deleteARightNoLeft pass! >>");
    }

    public static void deleteHasRightChildTree() {
        AvlBlackCover<Integer> tree = init();
        tree.remove(8);
        String treePreTraver = tree.checkedTreeWithHeight();
        assert ("[13 (h: 4)] [6 (h: 3)] [4 (h: 2)] [1 (h: 1)] [5 (h: 1)] [7 (h: 1)] [17 (h: 2)] [14 (h: 1)] [20 (h: 1)] ".equals(treePreTraver));
        System.out.println(">> test deleteHasRightChildTree pass! >>");
    }

    //build a tree from bottom to top
    private static AvlBlackCover<Integer> init() {
        @SuppressWarnings("all")
        AvlBlackCover.Node[] nodes = new AvlBlackCover.Node[21];
        for (int i = 1; i <= 20; i++) {
            nodes[i] = new AvlBlackCover.Node<>(i);
        }
        //set height and parent
        nodes[4].left = nodes[1];
        nodes[4].right = nodes[5];
        nodes[4].height = 2;

        nodes[6].left = nodes[4];
        nodes[6].right = nodes[7];
        nodes[6].height = 3;

        nodes[8].left = nodes[6];
        nodes[8].right = nodes[14];
        nodes[8].height = 4;

        nodes[14].left = nodes[13];
        nodes[14].right = nodes[17];
        nodes[14].height = 3;

        nodes[17].right = nodes[20];
        nodes[17].height = 2;

        @SuppressWarnings("all")
        AvlBlackCover<Integer> tree = new AvlBlackCover<>(nodes[8]);
        String treePreTraver = tree.checkedTreeWithHeight();
        assert ("[8 (h: 4)] [6 (h: 3)] [4 (h: 2)] [1 (h: 1)] [5 (h: 1)] [7 (h: 1)] [14 (h: 3)] [13 (h: 1)] [17 (h: 2)] [20 (h: 1)] ".equals(treePreTraver));
        return tree;
    }

    public static void main(String[] args) {
        deleteLeaf();
        deleteHasLeftTreeNoRight();
        deleteARightNoLeft();
        deleteHasRightChildTree();
    }
}
