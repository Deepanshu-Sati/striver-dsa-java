package BinarySearch.BSOn1DArrays;

/*
 * Link             : https://leetcode.com/problems/find-peak-element/
 * Problem          : Find peak element
 * Difficulty       : Medium
 * Approach         : Binary Search
 * Time complexity  : O(logN)
 * Space complexity : O(1)
 */
class Solution {
    static int findPeakElement(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        while(s<e){
            int m = s + (e-s)/2;
           
            if (nums[m]>nums[m+1]){
                //decreasing part 
                e = m;
            }
            else{
                //increasing part
                s = m+1;
            }

        }
        return s;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,6,7,9,4,3};
        System.out.println("Index of peak element : "+findPeakElement(nums));
    }
}