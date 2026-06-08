package ProblemsOnArrays.Easy;

/*
 * Problem         : Left rotate the array by one.
 * Difficulty      : Easy
 * Approach        : Linear Scan
 * Time Complexity : O(N)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

public class LeftRotateBy1 {
    public static void main(String[] args){
        int[] nums = {0,4,7,9,5};
        rotate1(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void rotate1(int[] nums){
        int n = nums.length-1;
        //store first element
        int first = nums[0];
        for (int i = 0; i<n; i++){
            // switch each element to left by one place
            nums[i] = nums[i+1];
        }
        //last element would be the first element of original array
        nums[n] = first;
    }
}
