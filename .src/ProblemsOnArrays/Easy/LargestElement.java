package ProblemsOnArrays.Easy;

/*
 * Problem: Largest Element in Array
 * Difficulty: Easy
 * Approach: Linear Search
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class LargestElement{
    public static void main(String[] args){
        int[] nums = {45,21,67,11,56};
        System.out.println(nums[idxLargest(nums)]);

    }
    static int idxLargest(int[] arr){
        if (arr == null || arr.length == 0){
            return -1;
        }
        int max = 0;
        for (int i = 0; i<arr.length; i++){
            if (arr[i]>arr[max]){
                max = i;
            }
        }
        return max;
    }
}