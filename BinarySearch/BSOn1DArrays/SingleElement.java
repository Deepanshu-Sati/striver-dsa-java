package BinarySearch.BSOn1DArrays;

/*
 * Link             : https://leetcode.com/problems/single-element-in-a-sorted-array/
 * Problem          : Single element in a sorted array
 * Difficulty       : Medium
 * Approach         : Binary Search
 * Time complexity  : O(N)
 * Space complexity : O(1)
 */

class SingleElement {
    static int singleNonDuplicate(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        while (s<e){
            int mid = s+(e-s)/2;
            //shifting mid to even position
            if (mid%2==1){
                mid--;
            }
            if(nums[mid]==nums[mid+1]){
                //mid (even index) is actually the first element
                //single term is ahead
                s = mid+2;
            }
            else{
                //mid term (even index) is not the first element
                //single term is behind or the current element
                e = mid;
            }
            //finally e == s;
        }
        return nums[s];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println("Single element is : "+singleNonDuplicate(nums) );
    }
}