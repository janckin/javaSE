package sort;

import java.util.Arrays;

public class TestQuickSort {
    static int[] arr = {5, 3, 1, 0, 2, 7, 4, 9, 6, 10};/* 偶数个数 */
    static int[] arr_order = {0, 1, 2, 3, 4, 5, 6, 7, 9, 10};
    static int[] arr2 = {9, 4, 11, 1, 2, 0, 10, 3, 6, 8, 5, 7};/* 奇数个数 */
    static int[] arr_order2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    static QuickSort qs = new QuickSort();

    public static void main(String[] args) {
        testDequeue();
        test3Index();
    }

    public static void testDequeue() {
        boolean success = true;
        int[] rs = qs.quickSort(arr);
        for (int i = 0; i < rs.length; i++) {
            if (rs[i] != arr_order[i]) {
                System.out.println("偶数个 ： fail!");
                System.out.println(Arrays.toString(rs));
                System.out.println(Arrays.toString(arr_order));
                success = false;
                break;
            }
        }
        if (success) System.out.println("偶数个 ： pass!");

        success = true;
        int[] rs2 = getArr(arr2);
        for (int i = 0; i < rs2.length; i++) {
            if (rs2[i] != arr_order2[i]) {
                System.out.println("奇数个 ： fail!");
                System.out.println(Arrays.toString(rs2));
                System.out.println(Arrays.toString(arr_order2));
                success = false;
                break;
            }
        }
        if (success) System.out.println("奇数个 ： pass!");
    }

    private static int[] getArr(int[] arr) {
        return qs.quickSort(arr);
    }

    public static void test3Index() {
        boolean success = true;
        int[] rs = qs.quickSortThreeValue(arr);
        for (int i = 0; i < rs.length; i++) {
            if (rs[i] != arr_order[i]) {
                System.out.println(Arrays.toString(rs));
                System.out.println(Arrays.toString(arr_order));
                success = false;
                break;
            }
        }
        if (success) {
            System.out.println("3数取中,偶数个 ： pass!");
        } else {
            System.out.println("3数取中,偶数个 ： fail!");
        }

        success = true;
        int[] rs2 = qs.quickSortThreeValue(arr2);
        for (int i = 0; i < rs2.length; i++) {
            if (rs2[i] != arr_order2[i]) {
                System.out.println(Arrays.toString(rs2));
                System.out.println(Arrays.toString(arr_order2));
                success = false;
                break;
            }
        }
        if (success) {
            System.out.println("3数取中,奇数个 ： pass!");
        } else {
            System.out.println("3数取中,奇数个 ： fail!");
        }

    }
}
