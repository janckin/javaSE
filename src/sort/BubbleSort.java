package sort;

public class BubbleSort {
    // use two loop to sort
    public void twoLoop(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    // use issort record is finished
    public void twoLoopWithIndex(int[] arr) {
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;

                    // record has changed
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    // use border to use
    public void twoLoopWithBorder(int[] arr) {
        int tmp = 0;
        int endBorder = arr.length - 1;
        boolean isSorted = true;
        for (int i = 0; i < arr.length; i++) {
            isSorted = true;
            int border = 0;
            for (int j = 0; j < endBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;

                    // record is changed
                    isSorted = false;

                    // record broder
                    border = j;
                }
            }
            // because block so make it out
            endBorder = border;
            if (isSorted) {
                break;
            }
        }
    }

    // cocktail
    public void CockTailSort(int[] array) {
        int tmp = 0;

        // 记录右侧最后一次交换的位置

        int lastRightExchangeIndex = 0;

        // 记录左侧最后一次交换的位置

        int lastLeftExchangeIndex = 0;

        // 无序数列的右边界，每次比较只需要比到这里为止

        int rightSortBorder = array.length - 1;

        // 无序数列的左边界，每次比较只需要比到这里为止

        int leftSortBorder = 0;

        for (int i = 0; i < array.length / 2; i++) {

            // 有序标记，每一轮的初始是true

            boolean isSorted = true;

            // 奇数轮，从左向右比较和交换

            for (int j = leftSortBorder; j < rightSortBorder; j++) {

                if (array[j] > array[j + 1]) {

                    tmp = array[j];

                    array[j] = array[j + 1];

                    array[j + 1] = tmp;

                    // 有元素交换，所以不是有序，标记变为false

                    isSorted = false;

                    lastRightExchangeIndex = j;

                }

            }

            rightSortBorder = lastRightExchangeIndex;

            if (isSorted) {

                break;

            }

            // 偶数轮之前，重新标记为true

            isSorted = true;

            // 偶数轮，从右向左比较和交换

            for (int j = rightSortBorder; j > leftSortBorder; j--) {

                if (array[j] < array[j - 1]) {

                    tmp = array[j];

                    array[j] = array[j - 1];

                    array[j - 1] = tmp;

                    // 有元素交换，所以不是有序，标记变为false

                    isSorted = false;

                    lastLeftExchangeIndex = j;

                }

            }

            leftSortBorder = lastLeftExchangeIndex;

            if (isSorted) {

                break;

            }

        }
    }
}
