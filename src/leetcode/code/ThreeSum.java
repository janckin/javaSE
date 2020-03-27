package leetcode.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        // initinal
        List<List<Integer>> rs = new ArrayList<List<Integer>>();

        // null point
        if (nums == null || nums.length < 3) {
            return rs;
        }

        bubbleSort(nums);
        int len = nums.length;

        // record the used num
        List<Integer> nums_list_left = new ArrayList<Integer>();
        int target = 0;
        // find the num
        for (int i = 0; i < len - 2; i++) {
            int first = nums[i];
            int left_index = i + 1;
            int right_index = len - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 跳过重复
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] > target) {
                break;
            }
            if (nums[i] + nums[right_index] + nums[right_index - 1] < target) {
                // 太小了
                continue;
            }
            while (left_index < right_index) {

                int second = nums[left_index];
                int third = nums[right_index];
                int sum = first + second + third;
                if (sum < target) {
                    left_index++;
                    while (left_index < right_index && nums[left_index] == nums[left_index - 1]) {
                        // 跳过重复
                        left_index++;
                    }
                } else if (sum > target) {
                    right_index--;
                    while (left_index < right_index && nums[right_index] == nums[right_index + 1]) {
                        // 跳过重复
                        right_index--;
                    }
                } else {
                    // 得到一个解
                    List<Integer> threeNum = new ArrayList<Integer>();
                    threeNum.add(first);
                    threeNum.add(second);
                    threeNum.add(third);
                    rs.add(threeNum);

                    left_index++;
                    right_index--;
                    while (left_index < right_index && nums[right_index] == nums[right_index + 1]) {
                        // 跳过重复
                        right_index--;
                    }
                    while (left_index < right_index && nums[left_index] == nums[left_index - 1]) {
                        // 跳过重复
                        left_index++;
                    }
                }

            }
            // record used numbers
            nums_list_left.add(first);
        }

        return rs;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        // initinal
        List<List<Integer>> rs = new ArrayList<List<Integer>>();

        List<Set<Integer>> sets = new ArrayList<Set<Integer>>();

        // null point
        if (nums == null || nums.length < 3) {
            return rs;
        }

        // map contains all int
        long start = System.currentTimeMillis();

        Map<Integer, Integer> nums_map = new HashMap<Integer, Integer>();
        List<Integer> nums_list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums_map.get(nums[i]) == null) {
                nums_map.put(nums[i], 1);
                nums_list.add(nums[i]);
            } else if (nums_map.get(nums[i]) >= 1) {
                nums_map.put(nums[i], nums_map.get(nums[i]) + 1);
            }
        }

        System.out.println((System.currentTimeMillis() - start) + " ms");

        // compare
        for (int i = 0; i < nums_list.size(); i++) {
            int first = nums_list.get(i);
            if (first == 0) {
                if (nums_map.get(0) > 2) {
                    // become result
                    List<Integer> threeNum = new ArrayList<Integer>();
                    threeNum.add(0);
                    threeNum.add(0);
                    threeNum.add(0);
                    rs.add(threeNum);
                }
            }
            for (int j = i + 1; j <= nums_list.size(); j++) {
                try {
                    int second = nums_list.get(j);
                    int key = -(first + second);
                    if (first == key || second == key) {
                        if (nums_map.get(key) <= 1) {
                            continue;
                        }

                    }
                    if (nums_map.get(key) != null) {
                        Set<Integer> set = new HashSet<Integer>();
                        set.add(first);
                        set.add(second);
                        // if (!isListExist(threeNum, rs)) {
                        if (!sets.contains(set)) {
                            sets.add(set);
                            List<Integer> threeNum = new ArrayList<Integer>();
                            threeNum.add(first);
                            threeNum.add(second);
                            threeNum.add(key);
                            rs.add(threeNum);
                        }
                    }
                } catch (Exception e) {
                    // j is end
                    continue;
                }
            }
        }

        return rs;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        // initinal
        List<List<Integer>> rs = new ArrayList<List<Integer>>();

        List<Set<Integer>> sets = new ArrayList<Set<Integer>>();

        // null point
        if (nums == null || nums.length < 3) {
            return rs;
        }

        // map contains all int
        Map<Integer, Integer> nums_map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums_map.get(nums[i]) == null) {
                nums_map.put(nums[i], 1);
            } else if (nums_map.get(nums[i]) >= 1) {
                nums_map.put(nums[i], nums_map.get(nums[i]) + 1);
            }
        }

        // find the parnter
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int first = nums[i];
                int second = nums[j];
                int key = -(first + second);
                if (first == key || second == key) {
                    if (nums_map.get(key) <= 1) {
                        continue;
                    }
                    if (first == 0 && second == 0) {
                        if (nums_map.get(key) < 3) {
                            continue;
                        }
                    }
                }
                if (nums_map.get(key) != null && nums_map.get(key) != 0) {
                    Set<Integer> set = new HashSet<Integer>();
                    set.add(first);
                    set.add(second);
                    set.add(key);
                    // if (!isListExist(threeNum, rs)) {
                    if (!sets.contains(set)) {
                        sets.add(set);

                        // become result
                        List<Integer> threeNum = new ArrayList<Integer>();
                        threeNum.add(first);
                        threeNum.add(second);
                        threeNum.add(key);
                        rs.add(threeNum);
                    }
                }
            }
        }
        return rs;
    }

    @SuppressWarnings("unused")
    private boolean isListExist(List<Integer> threeNumList, List<List<Integer>> rs) {
        if (rs.contains(threeNumList)) {
            return true;
        }
        int first = threeNumList.get(0);
        int second = threeNumList.get(1);
        int third = threeNumList.get(2);

        List<Integer> list = new ArrayList<Integer>();
        list.add(first);
        list.add(third);
        list.add(second);
        if (rs.contains(list)) {
            return true;
        } else {
            list.clear();
        }

        list.add(second);
        list.add(first);
        list.add(third);
        if (rs.contains(list)) {
            return true;
        } else {
            list.clear();
        }

        list.add(second);
        list.add(third);
        list.add(first);
        if (rs.contains(list)) {
            return true;
        } else {
            list.clear();
        }

        list.add(third);
        list.add(first);
        list.add(second);
        if (rs.contains(list)) {
            return true;
        } else {
            list.clear();
        }

        list.add(third);
        list.add(second);
        list.add(first);
        if (rs.contains(list)) {
            return true;
        } else {
            list.clear();
        }

        return false;
    }

    public void bubbleSort(int[] arr) {
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
}
