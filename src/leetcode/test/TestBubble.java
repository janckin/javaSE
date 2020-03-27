package leetcode.test;

import sort.BubbleSort;

import java.util.Arrays;

class TestBubble {
    BubbleSort bs = new BubbleSort();

    //@Test
    void test() {
        int[] arr1 = {-1, 0, 1, 2, -1, -4};
        int[] rs1 = {-4, -1, -1, 0, 1, 2};
        bs.twoLoop(arr1);
        //assertTrue(Arrays.equals(rs1, arr1));

        int[] arr2 = {-1, 0, 1, 2, -1, -4};
        bs.twoLoopWithIndex(arr2);
        //assertTrue(Arrays.equals(rs1, arr2));

        int[] arr3 = {-1, 0, 1, 2, -1, -4};
        bs.twoLoopWithBorder(arr3);
       // assertTrue(Arrays.equals(rs1, arr3));

        int[] arr4 = {-1, 0, 1, 2, -1, -4};
        bs.CockTailSort(arr4);
        //assertTrue(Arrays.equals(rs1, arr4));

        int[] arr5 = {1, 3, 3, 4, 8, -1, 4, 7, 8};
        int[] rs2 = {-1, 1, 3, 3, 4, 4, 7, 8, 8};
        bs.CockTailSort(arr5);
        for (int i = 0; i < arr5.length; i++) {
            System.out.print(arr5[i] + ",");
        }
        //assertTrue(Arrays.equals(rs2, arr5));
    }

}
