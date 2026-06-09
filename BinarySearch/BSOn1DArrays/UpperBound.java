package BinarySearch.BSOn1DArrays;

/*
 * Problem          : Find index of upper bound in a sorted array
 * Difficulty       : Easy
 * Approach         : Binary Search
 * Time complexity  : O(logN)
 * Space complexity : O(1)
 */

public class UpperBound {
    public static void main(String[] args){
        int[] nums = {1,2,3,3,4,5,6};
        int target = 1;
        int idx = searchUpper(nums, target);
        if (idx == -1){
            System.out.println("The array must have at least one element!");
        }
        else if (idx==nums.length){
            System.out.println("Target element is greater than or equal to the largest element of the array! So upper bound doesn't exist!");
        }
        else{
            System.out.println("Index of upper bound is : "+idx);
        }
    }

    static int searchUpper(int[] nums, int target){
        //The upper bound is the smallest index, ind, where arr[ind] > x.

        //handling cases of null or empty array
        if (nums == null || nums.length == 0){
            return -1;
        }

        //if the target element is greater than or equal to largest element of the array itself, so no upper bound exists
        if(target>=nums[nums.length-1]){
            return nums.length;
        }

        //for general cases
        int s = 0;
        int e = nums.length-1;
        while(s<e){
            int m = s +(e-s)/2;
            if (nums[m]<=target){
                s = m+1;
            }
            else{
                e = m;
            }
        }
        return s; //or return e, as the loop breaks at s=e

    }
}
