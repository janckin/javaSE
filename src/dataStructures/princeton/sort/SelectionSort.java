package dataStructures.princeton.sort;

public class SelectionSort {
    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            int next = i + 1;
            for (int j = next; j < arr.length; j++) {
                if (SortUtils.isLess(arr, j, index)) {
                    index = j;
                }
            }
            SortUtils.exch(arr, i, index);
        }
    }
}
