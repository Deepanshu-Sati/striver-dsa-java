package ProblemsOnArrays.Medium;

/*
 * Link             : https://leetcode.com/problems/two-sum/
 * Problem          : Two sum
 * Difficulty       : Easy-Medium
 * Approach         : Hashmaps
 * Time complexity  : O(NlogN)  {Average case : O(n)}
 * Space complexity : O(N)
 */

import java.util.Arrays;
import java.util.HashMap;

class TwoSum {
    static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int more = target-nums[i];
            if(map.containsKey(more)){
                return new int[]{map.get(more), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args){
        int[] nums = {4,1,7,2,3};
        int target = 7;
        System.out.println("Elements at these indices sum up to the target: "+ Arrays.toString(twoSum(nums, target)));
    }
}