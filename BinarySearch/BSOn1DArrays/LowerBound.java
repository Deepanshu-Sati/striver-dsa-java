package BinarySearch.BSOn1DArrays;

/*
 * Problem          : Find index of lower bound in a sorted array.
 * Difficulty       : Easy
 * Approach         : Binary search
 * Time complexity  : O(logN)
 * Space complexity : O(1)
 */

public class LowerBound {
    public static void main(String[] args){
        int[] nums = {5};
        int target = 4;
        int lb = searchLower(nums, target);

        if (lb == -1){
            System.out.println("Please provide array with at least one element!");
        }
        else if (lb == nums.length){
            System.out.println("Target element itself is larger than the largest element of the array!");
        }
        else{
            System.out.println("Lower bound index is : "+ lb);
        }
    }

    static int searchLower(int[] nums, int target){
        //Lower bound = first index i such that nums[i] >= target.

        //for null or empty array;
        if (nums == null || nums.length == 0) return -1;

        // if array doesn't have any element larger than or equal to the target element
        if (target>nums[nums.length-1]) return nums.length;

        //General cases;
        int s = 0;
        int e = nums.length-1;

        int ans_idx = -1;
        while(s<=e){
            int m = s + (e-s)/2;
            if (nums[m] > target){
                ans_idx = m;
                e = m-1;
            }
            else{
                s = m+1;
            }
        }
        return ans_idx;
    }

}
