package BinarySearch.BSOn1DArrays;

/*
 * Link             : https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Problem          : Search in rotated sorted array - I
 * Difficulty       : Medium
 * Approach         : Binary Search
 * Time Complexity  : O(logN)
 * Space Complexity : O(1)
 */

class SearchInRotatedSortedArrayI {
    public static void main(String[] args){
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println("Index of target : "+search(arr, target));
    }
    static int search(int[] nums, int target) {
        int s = 0;
        int max = maxElement(nums);
        int ans = bs(nums, target, s, max);
        if (ans == -1) {
            s = max+1;
            int end = nums.length-1;
            ans = bs(nums, target, s, end);
        }
        return ans;

        
    }
    static int maxElement(int[] nums){
        int s = 0;
        int e = nums.length-1;
        int m=0;
        while(s<e){
            m = s + (e-s)/2;
            if (nums[m]>nums[s]) s = m;
            else e = m;
        }
        return m;
    }

    static int bs(int[] nums, int target, int start, int end){
        while(start<=end){
            int mid = start + (end-start)/2;
            if (nums[mid] > target) end = mid-1;
            else if (nums[mid] < target) start = mid+1;
            else return mid;
        }
        return -1;
    }
}