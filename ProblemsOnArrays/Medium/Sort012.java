package ProblemsOnArrays.Medium;

/*
 * Link             : https://leetcode.com/problems/sort-colors/
 * Problem          : Sort an array of 0s, 1s and 2s.
 * Approach         : Dutch National Flag algorithm (two pointer approach)
 * Difficulty       : Medium
 * Time complexity  : O(N)
 * Space complexity : O(1)
 */

import java.util.Arrays;

class Sort012 {
    static void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int i = 0;
        while(i<=high){
            if (nums[i]==0){
                swap(nums,i,low);
                low++;
                i++;
            }
            else if (nums[i]==2){
                swap(nums,i,high);
                high--;
            }
            else{
                i++;
            }
        }
    }

    static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,1,1,0,2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}