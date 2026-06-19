package ProblemsOnArrays.Medium;

/*
 * Link             : https://leetcode.com/problems/majority-element/
 * Problem          : Majority Element - I
 * Difficulty       : Easy
 * Approach         : Linear Scan
 * Time complexity  : O(N)
 * Space complexity : O(1)
 */

class MajorityElement1 {
    static int majorityElement(int[] nums) {
        int element = nums[0];
        int count = 0;
        for (int i = 0; i<nums.length; i++){
            if (count == 0){
                element = nums[i];
            }
            if (nums[i] != element){
                count--;
            }
            else{
                count++;
            }
            
        }
        return element;
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,1,2,1,1,1,1};
        System.out.println("Majority element is : "+majorityElement(nums));
    }
}