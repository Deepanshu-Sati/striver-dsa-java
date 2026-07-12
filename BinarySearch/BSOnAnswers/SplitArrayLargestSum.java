package BinarySearch.BSOnAnswers;

/*
 * Link             : https://leetcode.com/problems/split-array-largest-sum/
 * Problem          : Split Array - Largest Sum
 * Approach         : Binary Search
 * Difficulty       : Hard
 * Time complexity  : O(n*log(sum)) (where sum is the sum of all elements of the array)
 * Space complexity : O(1)
 */

class SplitArrayLargestSum {
    static int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for(int num : nums){
            high += num;
            if(num>low){
                low = num;
            }
        }

        //low is largest element of the array (minimum sum of a subarray)
        //high is the sum of all elements of the array (maximum sum of a subarray)

        while(low<high){
            int mid = low + (high-low)/2;
            if(parts(nums, mid)>k){
                //array is being split into more parts than k, for this sum mid
                //so we need to increase this sum value
                low = mid+1;
            }
            else{
                //array is being split into parts less than or equal to k, for this sum mid
                // so we need to decrease the sum value
                high = mid;
            }
        }
        return high;
    }

    static int parts(int[] nums, int sum){
        int part = 1;
        int sum_calc = 0;
        for(int num : nums){
            if (sum_calc+num<=sum){
                sum_calc += num;
            }
            else{
                part++;
                sum_calc=num;
            }
        }

        return part;
    }

    public static void main(String[] args){
        int[] nums = {1,4,4};
        int k = 3;
        System.out.println("Minimised largest sum of the subarray, when array is divided in k parts: "+splitArray(nums, k));
    }
}