package com.leetcode;

import java.io.*;
import java.util.HashSet;
/**
 * Project Name : Find Longest Consecutive Sequence
 * File Name : FindLongestConsecutiveSequence
 * Creator : Hanbing Wang
 * Date : Dec 19, 2018
 */
public class FindLongestConsecutiveSequence {
    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     For example,
     Given [100, 4, 200, 1, 3, 2],
     The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
     time complexity: O(n)
     space complexity: O(n)
     * Input: int[] nums （an unsorted array of integers)
     * Output:int (the length of the longest consecutive elements sequence)
     */
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;         /* special case */
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for (int num : nums) {         /* put every number into a hash set, getting rid of duplicate*/
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            int down = nums[i] - 1;
            while (set.contains(down)) {    /* check if the hash set contains integers smaller than previous one by 1 */
                set.remove(down);
                down--;
            }
            int up = nums[i] + 1;
            while (set.contains(up)) {      /* check if the hash set contains integers greater than previous one by 1 */
                set.remove(up);
                up++;
            }
            result = Math.max(result, up - down - 1);    /* Compare and update the result*/
        }
        return result;
    }
    public static void main(String args[]) throws IOException {
        int TestlongestConsecutive = longestConsecutive(new int[]{10,5,6,4,11,13,12,1,2});
        System.out.println(TestlongestConsecutive == 4);
    }
}

