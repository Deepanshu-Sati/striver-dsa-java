package BinarySearch.BSOnAnswers;

/*
 * Link             : https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
 * Problem          : Find the smallest divisor
 * Difficulty       : Medium
 * Approach         : Binary Search
 * Time complexity  : O(n*log(Max)), where Max = maximum element in the array
 * Space complexity : O(1)
 */

class SmallestDivisor {

    public static void main(String[] args) {
        int[] nums = {44,22,33,11,1};
        int threshold = 5;
        System.out.println("Smallest divisor : "+smallestDivisor(nums, threshold));
    }
    static int smallestDivisor(int[] nums, int threshold) {
        int min_divisor = 1;
        int max_divisor = nums[0];
        for (int num : nums){
            if (num>max_divisor) max_divisor = num;
        }

        //apply binary search in range min_divisor to max_divisor

        int start = min_divisor;
        int end = max_divisor;
        int answer = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if (sum_quotient(nums, mid) <= threshold){
                answer = mid;
                //sum less than equal to threshold means we need a smaller divisor to increase the sum
                //we need to check for smaller divisor
                end = mid-1;    
            }
            else{
                //sum greater than threshold means we need a bigger divisor to decrease the sum
                start = mid+1;
            }
        }
        return answer;
    }

    static int sum_quotient(int[] nums, int divisor){
        int sum = 0;
        for (int num : nums){
            sum += (num+divisor-1)/divisor;
        }
        return sum;
    }
}