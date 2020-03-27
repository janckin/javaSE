package leetcode.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import leetcode.code.TwoArrayTogether;

class TestArrayTogether {
    TwoArrayTogether two = new TwoArrayTogether();

    @Test
    void test() {
        int[] num11 = {1, 2, 3, 0, 0, 0};
        int[] num21 = {4, 5, 6};
        two.merge(num11, 3, num21, 3);
        int[] rs11 = {1, 2, 3, 4, 5, 6};
        assertTrue(Arrays.equals(num11, rs11));


        int[] num12 = {10, 22, 23, 27, 28, 0, 0, 0};
        int[] num22 = {1, 2, 3};
        two.merge(num12, 5, num22, 3);
        int[] rs22 = {1, 2, 3, 10, 22, 23, 27, 28};
        assertTrue(Arrays.equals(num12, rs22));

        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        two.merge(num1, 3, num2, 3);
        int[] rs = {1, 2, 2, 3, 5, 6};
        assertTrue(Arrays.equals(num1, rs));

        int[] nums1 = {1, 3, 3, 4, 8, 0, 0, 0, 0};
        int[] nums2 = {-1, 4, 7, 8};
        int[] rs2 = {-1, 1, 3, 3, 4, 4, 7, 8, 8};
        two.merge(nums1, 5, nums2, 4);
        assertTrue(Arrays.equals(nums1, rs2));
    }

    @Test
    public void testStream() {
        List<Integer> list = new ArrayList<Integer>();
        list.stream();
    }

}
