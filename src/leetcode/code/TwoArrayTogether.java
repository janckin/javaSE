package leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoArrayTogether {
    // 8ms
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> rs = new ArrayList<Integer>();
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }
        // all elements in nums2 bigger than nums1's
        if (nums1[m - 1] < nums2[0]) {
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }
            return;
        }
        // all elements in nums1 bigger than nums2's
        if (nums1[0] > nums2[n - 1]) {
            int len = Math.abs(n);
            // change nums1 elements
            for (int i = m - 1; i >= 0; i--) {
                nums1[len + i] = nums1[i];
            }
            // input nums2 elements
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int leftBorder = 0;
        int leftIndex = 0;
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    if (nums1[0] > nums2[j]) {
                        rs.add(nums2[j]);
                        leftIndex = j;
                    }
                }
                leftBorder = leftIndex;
            }
            rs.add(nums1[i]);
            for (int j = leftBorder; j < n; j++) {
                if (i == m - 1) {
                    if (nums1[i] <= nums2[j]) {
                        rs.add(nums2[j]);
                        leftIndex = j;
                    }
                } else {
                    if (nums1[i] <= nums2[j] && nums2[j] < nums1[i + 1]) {
                        rs.add(nums2[j]);
                        leftIndex = j;
                    }
                }
            }
            leftBorder = leftIndex;
        }
        System.out.println(rs);
        for (int i = 0; i < rs.size(); i++) {
            nums1[i] = rs.get(i);
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        cockTailBubbleSort(nums1);
    }

    private void cockTailBubbleSort(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            boolean isSorted = true;
            int rightBorder = nums.length - 1;
            int leftBorder = 0;
            int tmp = 0;

            // 从左往右
            int rightIndex = 0;
            for (int j = leftBorder; j < rightBorder; j++) {
                if (nums[j] > nums[j + 1]) {
                    tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;

                    isSorted = false;
                    rightIndex = j;
                }
            }
            rightBorder = rightIndex;
            if (isSorted) {
                break;
            }

            // 从右往左
            int leftIndex = 0;
            for (int j = rightBorder; j > leftBorder; j--) {
                if (nums[j] < nums[j - 1]) {
                    tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;

                    isSorted = false;
                    leftIndex = j;
                }
            }
            leftBorder = leftIndex;
            if (isSorted) {
                break;
            }
        }
    }

    public boolean containsDuplicate(int[] nums) {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                list.add(nums[i]);
            } else {
                return true;
            }
        }
        if (list.size() <= 1) {
            return true;
        }
        return false;
    }
}
