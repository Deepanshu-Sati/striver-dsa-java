package BinarySearch.BSOn1DArrays;

/*
 * Link             : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Problem          : Find the minimum element in a rotated sorted array
 * Difficulty       : Medium
 * Approach         : Binary Search
 * Time complexity  : O(logN)
 * Space complexity : O(1)
 */

class MinRotatedSorted {
    static int findMin(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        while(s<e){
            int m = s + (e-s)/2;
            if(nums[m]>nums[e]){
                //minimum element is in the right half
                s = m+1;
            }   
            else{
                //minimum element is in the left half (or the middle element itself)
                e = m;
            }
        }
        //loop ends at s = e
        return nums[s];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,1,2,3,4};
        System.out.println("Smallest element : "+findMin(nums));
    }
}