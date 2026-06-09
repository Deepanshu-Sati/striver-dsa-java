package BinarySearch.BSOn1DArrays;

/*
 * Link             : https://leetcode.com/problems/search-insert-position/
 * Problem          : Search Insert Position
 * Difficulty       : Easy
 * Approach         : Binary Search
 * Time Complexity  : O(logN)
 * Space Complexity : O(1)
 */

class SearchInsertPosition {
    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        int target = 2;
        int idx = searchInsert(nums, target);
        System.out.println("Suitable index of the target : "+idx);
    }
    static int searchInsert(int[] nums, int target) {
        //Given a sorted array of distinct integers and a target value, return the index if the target is found.
        //If not, return the index where it would be if it were inserted in order.
        int s = 0;
        int e = nums.length-1;
        while(s<=e){
            int m = s + (e-s)/2;
            if (nums[m] == target) return m;
            if (nums[m] > target) e = m-1;
            else s = m+1; 
        }
        return s;
    }
}