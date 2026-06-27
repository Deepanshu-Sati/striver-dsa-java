package ProblemsOnArrays.Medium;

/*
 * Link             : https://leetcode.com/problems/maximum-subarray/
 * Problem          : Kadane's Algorithm / Maximum subarray
 * Difficulty       : Medium
 * Approach         : Kadane's Algorithm
 * Time complexity  : O(N)
 * Space complexity : O(1)
 */

public class KadaneAlgorithm {
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maximumSum(nums));
    }

    private static int maximumSum(int[] nums) {
        //Kadane's Algorithm
        int max_sum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums){
            sum+=num;
            if(sum>max_sum){
                max_sum = sum;
            }
            if(sum<0){
                sum = 0;
            }
        }
        return max_sum;
    }

}
