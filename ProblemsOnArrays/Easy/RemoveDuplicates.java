package ProblemsOnArrays.Easy;

/*
 * Problem link : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Problem: Remove duplicates from sorted array
 * Difficulty: Easy
 * Approach: Linear Search with two pointers.
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

class RemoveDuplicates {
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j<nums.length; j++){
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("Number of unique elements in array : "+removeDuplicates(nums));
    }
}