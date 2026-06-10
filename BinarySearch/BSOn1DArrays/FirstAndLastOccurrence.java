package BinarySearch.BSOn1DArrays;

/*
 * Link             : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Problem          : Find first and last occurrence of target element in a sorted array
 * Difficulty       : Medium
 * Approach         : Binary Search
 * Time Complexity  : O(logN)
 * Space Complexity : O(1)
 */

import java.util.Arrays;

class FirstAndLastOccurrence {
    public static void main(String[] args){
        int[] nums = {1,2,2,2,3,4,5};
        int target = 2;
        System.out.println("Range of target : "+ Arrays.toString(searchRange(nums, target)));
    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        ans[0] = search(nums, target, true);
        if (ans[0] !=-1){
            ans[1] = search(nums, target, false);
        }
        return ans;
    }
    static int search(int[] nums, int target, boolean isFirst){
        int s = 0;
        int e = nums.length-1;
        int ans = -1;
        while(e>=s){
            int m = s + (e-s)/2;
            if (nums[m]>target) e = m-1;
            else if (nums[m]<target) s = m+1;
            else {//nums[m] == target
                ans = m;
                if (isFirst){
                    //we are looking for first occurrence
                    e = m-1;
                }else {
                    //we are looking for last occurrence
                    s = m+1;
                }
            }
        }
        return ans;
    }
}