package BinarySearch.BSOn1DArrays;

/*
 * Link             : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * Problem          : Search in rotated sorted array - II (duplicate elements allowed)
 * Difficulty       : Easy-Medium
 * Approach         : Binary Search
 * Time complexity  : O(logN)
 * Space complexity : O(1)
 */

class SearchInRotatedSortedArrayII {

    public static void main(String[] args){
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        System.out.println("Target present in array : "+search(nums, target));
    }
    static boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (nums[m] == target) {
                return true;
            }

            // Cannot determine the sorted half
            if (nums[s] == nums[m] && nums[m] == nums[e]) {
                s++;
                e--;
            }

            // Left half is sorted
            else if (nums[s] <= nums[m]) {
                if (target >= nums[s] && target < nums[m]) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }

            // Right half is sorted
            else {
                if (target > nums[m] && target <= nums[e]) {
                    s = m + 1;
                } else {
                    e = m - 1;
                }
            }
        }

        return false;
    }
}