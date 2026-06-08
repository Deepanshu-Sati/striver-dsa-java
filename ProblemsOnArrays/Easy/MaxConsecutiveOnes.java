package ProblemsOnArrays.Easy;

/*
 * Link             : https://leetcode.com/problems/max-consecutive-ones/
 * Problem          : Find the maximum number of consecutive ones in a binary array of 0s and 1s.
 * Difficulty       : Easy
 * Approach         : Linear Search
 * Time Complexity  : O(N)
 * Space Complexity : O(1)
 */

class MaxConsecutiveOnes {
    static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int count_old = 0;
        for (int num : nums) {
            if (num == 1) {
                count += 1;
            } else {
                //when element is zero, start new count, store old count, if it is greater than the current count.
                if (count > count_old) {
                    count_old = count;
                }
                count = 0;
            }
        }
        return Math.max(count, count_old);
    }

    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,0,0,1,1,1,0,1,1};
        System.out.println("Maximum number of consecutive ones is : "+findMaxConsecutiveOnes(nums));
    }
}