package dataStructures.princeton.sort;

public class MergeSort {
    public static void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        //the merge gap is basic on mid
        int mid = (lo + hi) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    /**
     * merge two subarray from index of lo and hi in arr
     *
     * @param arr original array
     * @param lo  the lower index
     * @param mid the middle index
     * @param hi  the highest index
     */
    public static void merge(Comparable[] arr, int lo, int mid, int hi) {
        if (lo > hi || lo > mid || mid > hi || arr.length == 0) {
            return;
        }
        int i = lo;
        int j = mid + 1;
        Comparable[] aux = arr.clone();
        for (int k = i; k <= hi; k++) {
            //array between lo and mid has run out
            if (i > mid) {
                arr[k] = aux[j];
                j++;
            } else if (j > hi) {
                //array between lo and mid has run out
                arr[k] = aux[i];
                i++;
            } else if (SortUtils.isLess(aux[i], aux[j]) || aux[i].equals(aux[j])) {
                // array between lo and mid and between mid and hi still need to merge
                arr[k] = aux[i];
                i++;
            } else {
                arr[k] = aux[j];
                j++;
            }
        }
    }
}
