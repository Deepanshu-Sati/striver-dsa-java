package ProblemsOnArrays.Medium;

/*
 * Link             : https://leetcode.com/problems/rearrange-array-elements-by-sign/
 * Problem          : Rearrange Array Elements By Sign
 * Difficulty       : Medium
 * Approach         : Linear search
 * Time complexity  : O(N)
 * Space complexity : O(N)
 */

import java.util.Arrays;

class RearrangeArrayElementsBySign {

    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }
    static int[] rearrangeArray(int[] nums) {
        int[] answer = new int[nums.length];
        int pos_index = 0;
        int neg_index = 1;
        for (int num : nums) {
            if (num > 0) {
                answer[pos_index] = num;
                pos_index += 2;
            } else {
                answer[neg_index] = num;
                neg_index += 2;
            }
        }
        return answer;
    }
}