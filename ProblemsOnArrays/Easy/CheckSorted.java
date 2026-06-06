package ProblemsOnArrays.Easy;

/*
 * Problem: Check if array is sorted II
 * Difficulty: Easy
 * Approach: Linear Search (compare adjacent elements, and last element with the first element, there is only one discontinuity allowed!)
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

class CheckSorted {
    public static void main(String[] args){
        int [] arr = {4,1,2,5};
        System.out.println("Is sorted rotated: "+ check(arr));
    }
    static boolean check(int[] nums) {
        int discont = 0;
        for (int i = 0; i<nums.length; i++){
            if (nums[i]>nums[(i+1)%nums.length]){
                discont++;
            }
        }
         //in a sorted and rotated array only one discontinuity can be tolerated, at the pivot point, other than that, it should be continuous and non-decreasing!
        return discont<=1;
    }
}