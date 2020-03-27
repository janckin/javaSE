package dataStructures.princeton.sort;

public class InsertionSort {
    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (SortUtils.isLess(arr[j], arr[j - 1])) {
                    SortUtils.exch(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
}
