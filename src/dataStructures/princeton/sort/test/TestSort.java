package dataStructures.princeton.sort.test;

import a.dataStructures.princeton.sort.MergeSort;
import a.dataStructures.princeton.sort.SortUtils;

public class TestSort {
    public static Comparable[] OLD = {1, 10, 15, 2, 4, 0, 4, 8, 5, 9, 15, 0, 16, 15};
    public static Comparable[] SP = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
    public static final Comparable[] RESULT = {0, 0, 1, 2, 4, 4, 5, 8, 9, 10, 15, 15, 15, 16};

    public static void main(String[] args) {
        //SelectionSort.sort(OLD);
        //InsertionSort.sort(OLD);
        //ShellSort.sort(OLD);
        MergeSort.sort(OLD);
        if (compareArray(OLD, RESULT)) {
            System.out.println("SORT SUCCESS!");
        } else {
            SortUtils.print(OLD);
            SortUtils.print(RESULT);
        }
    }

    private static boolean compareArray(Comparable[] a1, Comparable[] a2) {
        if (a1.length != a2.length) {
            return false;
        }
        int len = a1.length;
        boolean result = true;
        for (int i = 0; i < len; i++) {
            if (a1[i] != a2[i]) {
                result = false;
                System.out.println("the different index is :" + i);
            }
        }
        return result;
    }
}
