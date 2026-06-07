package ProblemsOnArrays.Easy;

/*
 * Problem link : https://leetcode.com/problems/move-zeroes/
 * Problem: Move zeroes to end.
 * Difficulty: Easy
 * Approach: Swap the non-elements to start pushing zeroes to end
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

class MoveZeroes {
    static void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j<nums.length; j++){
            if (nums[j]!=0){
                if (i!=j){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                i++;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {0,9,3,0,12,4};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}