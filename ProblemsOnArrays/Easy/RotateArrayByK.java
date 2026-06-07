package ProblemsOnArrays.Easy;

/*
 * Problem link : https://leetcode.com/problems/rotate-array/
 * Problem: Right rotate array by k places.
 * Difficulty: Easy-Medium
 * Approach: Reverse the array, then reverse the initial k elements, then remaining elements.
 * Time Complexity: O(N)
 * Space Complexity: O(1)
*/

import java.util.Arrays;

class RotateArrayByK {
    static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);  
    }

    static void reverse(int[] nums, int left, int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args){
        int[] arr = {1,54,21,78,99};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}