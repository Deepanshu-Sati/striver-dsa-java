package ProblemsOnArrays.Easy;

/*
 * Link             : https://leetcode.com/problems/single-number/
 * Problem          : Find the number that appears once, and other numbers appear twice
 * Difficulty       : Easy
 * Approach         : Use of xor (^) operator
 * Time complexity  : O(N)
 * Space complexity : O(1)
 */

class NumberAppearsOnce {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,2,4,5,4,6,5,6};
        System.out.println("Single number is : "+singleNumber(nums));
    }
    static int singleNumber(int[] nums) {
        // a^0 = a
        // a^a = 0
        int xor = 0;
        for (int num : nums){
            xor ^= num;
        }
        return xor;
    }
}