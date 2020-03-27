package dataStructures.princeton.sort;

public class SortUtils {

    public static boolean isLess(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isLess(Comparable[] arr, int small, int large) {
        return isLess(arr[small], arr[large]);
    }

    /**
     * justify whether the array is sorted
     *
     * @param arr a sorted array
     * @return result of array
     */
    public static boolean isSort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (isLess(arr[i], arr[i - 1])) return false;
        }
        return true;
    }

    /**
     * exchange the value in i and j of array
     *
     * @param arr the array
     * @param i   the first index
     * @param j   the second index
     */
    public static void exch(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * print the context of array
     *
     * @param arr the array
     */
    public static void print(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("---end----");
    }
}
