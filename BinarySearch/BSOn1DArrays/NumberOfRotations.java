package BinarySearch.BSOn1DArrays;

/*
 * Problem : Find the number of times a sorted (non-decreasing) array (distinct elements) has been rotated
 * Difficulty : Easy
 * Approach : Binary Search
 * Time complexity : O(logN)
 * Space complexity : O(1)
 */

public class NumberOfRotations {
    public static void main(String[] args){
        int[] nums = {3,4,5,6,7,1,2};
        System.out.println("Number of left rotations : "+nRotations(nums));
    }

    static int nRotations(int[] nums){
        int s = 0;
        int e = nums.length-1;
        while(s<e){
             int m = s+(e-s)/2;
             if(nums[m]>nums[e]){
                 //smallest element is in right half
                 s = m+1;
             }
             else{
                 //smallest element is in the left half, oe the middle element itself
                 e = m;
             }
        }
        //loop breaks at s = e.
        //index of the smallest element gives the number of rotations
        return s;
    }
}
