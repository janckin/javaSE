package dataStructures.tree.test;

import dataStructures.tree.BinarySearchNode;
import dataStructures.tree.BinarySearchTree;
import dataStructures.tree.Node;
import dataStructures.tree.TreeHelper;

public class testTree {


    public static void main(String[] args) {
        /*
        test traverse: preOrder/inOrder/postOrder
        */
        TreeHelper<String> th = new TreeHelper<>();
        th.insert(createATree());
        th.printTree();


        BinarySearchTree<Integer> bsn = new BinarySearchTree<>();

        BinarySearchNode<Integer> target = new BinarySearchNode<>(80);
        BinarySearchNode<Integer> root = new BinarySearchNode<>(binarySearchTree());
        bsn.insert(root);
        /*
         * test contain method
         * System.out.println(bsn.contain(target, root));
         */

        /*
         *test finMin
         */
        //System.out.println(bsn.findMin().getContext());

        /*
         * test finMax
         */
        //System.out.println(bsn.findMax().getContext());

        /*
         *test remove
         */
        /*bsn.remove(target);
        System.out.println(">> the tree is here:");
        TreeHelper<Integer> th = new TreeHelper<>();
        th.insert(BinarySearchNode.parseNode(bsn.getRoot()));
        th.printTree();*/

    }

    /**
     * create a tree
     * result:
     * preOrder:A B D F G M E I J K H L C N O P Q R S T
     * inOrder:GFMDJIKELHBAONCRQPTS
     * postOrder:GMFJKILHEDBONRQTSPCA
     *
     * @return root node
     */
    private static Node<String> createATree() {
        Node<String> A = new Node<String>("A");
        Node<String> B = new Node<String>("B");
        Node<String> C = new Node<String>("C");
        Node<String> D = new Node<String>("D");
        Node<String> E = new Node<String>("E");
        Node<String> F = new Node<String>("F");
        Node<String> G = new Node<String>("G");
        Node<String> H = new Node<String>("H");
        Node<String> I = new Node<String>("I");
        Node<String> J = new Node<String>("J");
        Node<String> K = new Node<String>("K");
        Node<String> L = new Node<String>("L");
        Node<String> M = new Node<String>("M");
        Node<String> N = new Node<String>("N");
        Node<String> O = new Node<String>("O");
        Node<String> P = new Node<String>("P");
        Node<String> Q = new Node<String>("Q");
        Node<String> R = new Node<String>("R");
        Node<String> S = new Node<String>("S");
        Node<String> T = new Node<String>("T");

        A.setLeft(B);
        A.setRight(C);

        B.setLeft(D);
        D.setLeft(F);
        D.setRight(E);
        F.setLeft(G);
        F.setRight(M);
        E.setLeft(I);
        E.setRight(H);
        I.setLeft(J);
        I.setRight(K);
        H.setLeft(L);

        C.setLeft(N);
        C.setRight(P);
        N.setLeft(O);
        P.setLeft(Q);
        P.setRight(S);
        Q.setLeft(R);
        S.setLeft(T);

        return A;
    }

    /**
     * create a binarySearchTree
     * <p>
     * inOrder:
     * postOrder: 30 55 65 60 76 78 77 75 85 80 70 40 107 108 109 110 180 140 150 100
     *
     * @auther lsy
     */

    private static Node<Integer> binarySearchTree() {

        BinarySearchNode<Integer> a100 = new BinarySearchNode<>(100);
        BinarySearchNode<Integer> a40 = new BinarySearchNode<>(40);
        BinarySearchNode<Integer> a150 = new BinarySearchNode<>(150);
        BinarySearchNode<Integer> a30 = new BinarySearchNode<>(30);
        BinarySearchNode<Integer> a70 = new BinarySearchNode<>(70);
        BinarySearchNode<Integer> a60 = new BinarySearchNode<>(60);
        BinarySearchNode<Integer> a80 = new BinarySearchNode<>(80);
        BinarySearchNode<Integer> a55 = new BinarySearchNode<>(55);
        BinarySearchNode<Integer> a65 = new BinarySearchNode<>(65);
        BinarySearchNode<Integer> a75 = new BinarySearchNode<>(75);
        BinarySearchNode<Integer> a85 = new BinarySearchNode<>(85);
        BinarySearchNode<Integer> a77 = new BinarySearchNode<>(77);
        BinarySearchNode<Integer> a78 = new BinarySearchNode<>(78);
        BinarySearchNode<Integer> a76 = new BinarySearchNode<>(76);
        BinarySearchNode<Integer> a140 = new BinarySearchNode<>(140);
        BinarySearchNode<Integer> a180 = new BinarySearchNode<>(180);
        BinarySearchNode<Integer> a110 = new BinarySearchNode<>(110);
        BinarySearchNode<Integer> a109 = new BinarySearchNode<>(109);
        BinarySearchNode<Integer> a108 = new BinarySearchNode<>(108);
        BinarySearchNode<Integer> a107 = new BinarySearchNode<>(107);

        a100.setLeft(a40);
        a100.setRight(a150);

        a40.setLeft(a30);
        a40.setRight(a70);
        a150.setLeft(a140);

        a70.setLeft(a60);
        a70.setRight(a80);
        a140.setLeft(a110);
        a140.setRight(a180);

        a60.setLeft(a55);
        a60.setRight(a65);
        a80.setLeft(a75);
        a80.setRight(a85);
        a110.setLeft(a109);

        a75.setRight(a77);
        a109.setLeft(a108);

        a77.setLeft(a76);
        a77.setRight(a78);
        a108.setLeft(a107);


        return a100;
    }
}
