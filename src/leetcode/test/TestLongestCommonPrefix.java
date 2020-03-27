package leetcode.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

import leetcode.code.LongestCommonPrefix;

class TestLongestCommonPrefix {
    LongestCommonPrefix prefix = new LongestCommonPrefix();

    @Test
    void testLongestCommonPrefix() {
        //NullPointerException
        //assertEquals("",null);
        String[] s_arr = {};
        //assertEquals((String)"",s_arr);

        String[] s_arr1 = {"flower", "flow", "flight"};
        assertEquals("fl", prefix.longestCommonPrefix(s_arr1));

        String[] s_arr2 = {"dog", "racecar", "car"};
        assertEquals("", prefix.longestCommonPrefix(s_arr2));

        String[] s_arr3 = {"hello", "hi", "href"};
        assertEquals("h", prefix.longestCommonPrefix(s_arr3));

        // test the time
        String[] s_arr4 = new String[10000];
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            s_arr4[i] = "juuul" + (char) (random.nextInt(26) + 97);
        }
        assertEquals("juuul", prefix.longestCommonPrefix(s_arr4));
    }

    @Test
    void testCharAt() {
        String hello = "hee";
        try {
            hello.charAt(3);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("get it !");
        }
    }
}
