package BinarySearch.BSOn1DArrays;

/*
 * Link             : https://leetcode.com/problems/binary-search/
 * Problem          : Find index of target element in a sorted (non-decreasing) integer array.
 * Difficulty       : Easy
 * Approach         : Binary Search
 * Time complexity  : O(logN)
 * Space complexity : O(1)
 */

class SearchXInSortedArray {
    static int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        while(s<=e){
            int m = s + (e-s)/2;
            if(nums[m]==target) return m;
            if(nums[m]<target) s = m+1;
            else e = m-1;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1,3,5,6,9,13};
        int x = 9;
        int idx = search(nums, x);
        System.out.printf("Index of %d is %d.", x, idx);
    }
}