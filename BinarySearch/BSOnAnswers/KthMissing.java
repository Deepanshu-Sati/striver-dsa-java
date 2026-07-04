package BinarySearch.BSOnAnswers;


/*
 * Link             : https://leetcode.com/problems/kth-missing-positive-number/
 * Problem          : Find Kth missing number
 * Difficulty       : Easy-Medium
 * Approach         : Binary Search
 * Time complexity  : O(N)
 * Space complexity : O(1)
 */


class KthMissing {

    public static void main(String[] args){
        int[] nums = {1,5,6,7};
        int k = 3;
        System.out.println("Kth missing number is : "+findKthPositive(nums, k));
    }
    static int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            int missing = arr[mid]-mid-1;

            if(missing<k){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low+k;
    }
}