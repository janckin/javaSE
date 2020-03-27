package dataStructures.princeton.sort;

public class MergeSortBU extends MergeSort {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int mergeSize = 1; mergeSize < n; mergeSize = mergeSize * 2) {
            for (int lo = 0; lo < n - mergeSize; lo = lo + 2 * mergeSize) {
                int mid = lo + mergeSize - 1;
                MergeSort.merge(arr, lo, mid, Math.min(lo + 2 * mergeSize - 1, n - 1));
            }
        }
    }
}
