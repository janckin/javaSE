package sort;

import java.util.Arrays;
import java.util.Objects;

//this class is used to learn about the quick sort
public class QuickSort {

    //利用trick：2个指针，后指针找小于等基数值，向前填坑，前指针向后找大数，向后填坑
    public int getIndexBySorting(int[] arr, int left, int right, int index) {
        try {
            Objects.checkFromToIndex(left, right, arr.length);
            Objects.checkFromToIndex(index, right, arr.length);
            Objects.checkFromToIndex(left, index, arr.length);
        } catch (Exception ex) {
            return -1;
        }
        if (left == right) {
            return -1;
        }
        //set the base is 0
        int base = arr[index];
        while (left < right) {
            //右侧指针移动，将大于基准数的位置跳过，获取比base小的index
            while (arr[right] >= base && left < right) {
                right = right - 1;
            }
            //填了index的坑，挖开right对应的坑
            if (left < right) {
                arr[index] = arr[right];
                index = right;
                //让左侧指针移动
                left++;
            }

            //左侧指针开始从当前位置移动，将小于基准数的位置跳过，获取比base大的index
            while (arr[left] < base && left < right) {
                left = left + 1;
            }
            //填了index的坑，挖开left对应的坑
            if (left < right) {
                arr[index] = arr[left];
                index = left;
                right--;
            }
        }
        arr[index] = base;
        return index;
    }

    public int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }


    private int[] quickSort(int[] arr, int left, int right) {
        int mid = getIndexBySorting(arr, left, right, left);
        if (mid == -1) {
            return arr;
        }
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid + 1, right);
        return arr;
    }

    public int[] quickSortThreeValue(int[] arr) {
        return quickSortThreeValueIndex(arr, 0, arr.length - 1);
    }

    private int[] quickSortThreeValueIndex(int[] arr, int left, int right) {
        modifyElementInThree(arr, left, right);
        return quickSort(arr, left, right);
    }

    //
    private void modifyElementInThree(int[] arr, int left, int right) {
        try {
            Objects.checkFromToIndex(left, right, arr.length);
        } catch (Exception ex) {
            return;
        }
        if (left == right) {
            return;
        }

        int midIndex = left + (right - left) / 2;

        if (arr[left] > arr[midIndex]) {
            exchange(arr, left, midIndex);
        }
        if (arr[left] > arr[right]) {
            exchange(arr, left, right);
        }
        //这时候left已经是最小值了
        if (arr[midIndex] > arr[right]) {
            exchange(arr, midIndex, right);
        }

        //设置好槽位
        if (arr[midIndex] > arr[right - 1]) {
            exchange(arr, midIndex, right - 1);
        }
    }

    private void exchange(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


}
