package BinarySearch.BSOn1DArrays;

/*
 * Problem          : Find indices of floor and ceiling of target in a sorted array
 * Difficulty       : Easy
 * Approach         : Binary Search
 * Time complexity  : O(logN)
 * Space complexity : O(1)
 */

public class FloorCeil {
    public static void main(String[] args){
        int [] nums = {1,3,5,8,9};
        int target = 0;
        int[] answer = floorCeilIndices(nums, target);
        if (answer[1] == -1){ //since function returns {-1,-1} for null or empty arrays
            System.out.println("Array should contain at least one element!");
        }
        else if(answer[0] == -1){
            System.out.println("Target is lower than the smallest element of the array! No floor exists!");
            System.out.println("Ceiling : "+nums[answer[1]]);
        }
        else if(answer[1] == nums.length){
            System.out.println("Floor : "+nums[answer[0]]);
            System.out.println("Target is larger than the largest element of the array! No ceil exists!");
        }
        else{
            System.out.println("Floor : "+nums[answer[0]]);
            System.out.println("Ceiling : "+nums[answer[1]]);
        }
    }

    static int[] floorCeilIndices(int[] nums, int target){
        //If array is null or empty
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }

        //If target<smallest element, i.e., floor doesn't exist
        if (target<nums[0]){
            return new int[]{-1,0};
        }

        //If target>largest element, i.e., ceiling doesn't exist
        if (target > nums[nums.length-1]){
            return new int[]{nums.length-1, nums.length};
        }

        //General case
        int s = 0;
        int e = nums.length-1;
        while(s<=e){
            int m = s + (e-s)/2;
            if (nums[m] == target){
                return new int[]{m,m};
            }
            else if(nums[m]>target){
                e = m-1;
            }
            else{
                s = m+1;
            }
        }
        return new int[]{e,s};
    }
}
