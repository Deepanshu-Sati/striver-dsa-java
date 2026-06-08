package ProblemsOnArrays.Easy;

/*
 * Problem          : Linear Search
 * Difficulty       : Easy
 * Approach         : Linear Search, iterate through every element of array and compare it with target.
 * Time complexity  : O(N)
 * Space complexity : O(1)
 */

public class LinearSearch {
    static int search(int[] nums, int target){
        for (int i = 0; i<nums.length; i++){
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int [] nums = {7,89,100,54,23};
        int target = 89;
        int idx = search(nums, target);
        if (idx == -1){
            System.out.println("No such element in the array!");
        }
        else {
            System.out.printf("Index of %d is %d.%n", target, idx);
        }
    }
}
