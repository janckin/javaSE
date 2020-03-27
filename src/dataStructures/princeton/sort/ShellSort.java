package dataStructures.princeton.sort;

public class ShellSort extends InsertionSort {
    public static int DIVIDER = 2;

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        int groupSize = n / DIVIDER;
        //divide arr into subarray and end when the groupSize == 1
        while (groupSize != 0) {
            for (int i = groupSize; i < n; i++) {
                int j = i;
                while (j - groupSize >= 0 && SortUtils.isLess(arr[j], arr[j - groupSize])) {
                    SortUtils.exch(arr, j, j - groupSize);
                    j = j - groupSize;
                }
            }
            groupSize = groupSize / DIVIDER;
        }
    }

    public static void sort_book(Comparable[] arr) {
        SortUtils.print(arr);
        int N = arr.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && SortUtils.isLess(arr[j], arr[j - h]); j -= h) {
                    System.out.println("exchange ready: " + arr[j] + " and " + arr[j - h]);
                    System.out.println("exchange index: " + j + " and " + (j - h));
                    SortUtils.exch(arr, j, j - h);
                    SortUtils.print(arr);
                }
            }
            h = h / 3;
        }
    }

    public static void sort_webSite(Comparable[] arr) {
        SortUtils.print(arr);
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            System.out.println(">>>> gap is " + gap);
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                while (j - gap >= 0 && SortUtils.isLess(arr[j], arr[j - gap])) {
                    System.out.println("-----before move");
                    SortUtils.print(arr);
                    System.out.println("exchange index: " + (j - gap) + " and " + j);
                    System.out.println("exchange ready: " + arr[j - gap] + " and " + arr[j]);
                    SortUtils.exch(arr, j, j - gap);
                    j -= gap;
                    System.out.println("-----after move");
                    SortUtils.print(arr);
                    System.out.println("-----end -------");
                }
            }
        }
    }
}
