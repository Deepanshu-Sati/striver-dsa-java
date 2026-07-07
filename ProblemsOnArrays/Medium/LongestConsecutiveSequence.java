package ProblemsOnArrays.Medium;

/*
 * Link             : https://leetcode.com/problems/longest-consecutive-sequence/
 * Problem          : Longest consecutive sequence in an array
 * Difficulty       : Medium
 * Approach         : Hash set and linear search for the first element of a subsequence
 * Time complexity  : O(n)
 * Space complexity : O(n)
 */

import java.util.HashSet;

class LongestConsecutiveSequence {
    static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int longest_sequence = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                //this num can be the starting of a sequence
                int count = 1;
                while(set.contains(num+1)){
                    count++;
                    num++;
                }
                if (count>longest_sequence){
                    longest_sequence = count;
                }
            }
        }
        return longest_sequence;
    }

    public static void main(String[] args){
        int[] nums = {86, 9,54,1,5,4,3,43,2};
        System.out.println("Length of longest sequence is: "+ longestConsecutive(nums));
    }
}