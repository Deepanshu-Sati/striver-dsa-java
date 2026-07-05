package ProblemsOnArrays.Medium;

/*
 * Problem          : Along with the maximum sum, also print that subarray with the maximum sum (followup of Kadane's algorithm)
 * Difficulty       : Medium
 * Approach         : Kadane's Algorithm
 * Time complexity  : O(N)
 * Space complexity : O(1)
 */

import java.util.Arrays;

public class KadaneAlgorithm2 {
    public static void main(String[] args){
        int[] nums = {-2, -3, -7, -2, -10, -4};
        int[] ans = kadane2(nums);
        int start = ans[0];
        int end = ans[1];
        int sum = ans[2];
        System.out.println("Maximum sum :"+sum);
        System.out.println("Largest subarray with max sum : "+ Arrays.toString(Arrays.copyOfRange(nums, start, end+1)));

    }

    static int[] kadane2(int[] nums){
        int sum = 0;
        int max_sum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        int i = 0;
        boolean max_change = false;
        while(i<nums.length){

            sum+=nums[i];
            if(sum>max_sum){
                max_sum = sum;
                end = i;
                max_change = true;
            }
            if(sum<0){
                sum = 0;
                if(max_change){
                    start = i;
                    max_change = false;
                }
            }
            i++;
        }

        return new int[]{start, end, max_sum};
    }
}
