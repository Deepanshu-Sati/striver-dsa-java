package ProblemsOnArrays.Medium;

/*
 * Link : https://leetcode.com/problems/next-permutation/
 * Problem : Next Permutation
 * Difficulty : Medium
 * Approach : Linear search and reversal of sorted array
 * Time complexity : O(n)
 * Space complexity : O(1)
 */

import java.util.Arrays;

class NextPermutation {

    public static void main(String[] args){
        int[] nums = {5,7,2,1};
        nextPermutation(nums);
        System.out.println("Next permutation is : "+ Arrays.toString(nums));
    }

    static void nextPermutation(int[] nums) {
        int i = nums.length-1;
        int j = i;
        while(j>0 && nums[j]<=nums[j-1]){
            j--;
        }
        //if j = 0; the array is sorted in descending order, so just reverse it, 
        if (j==0){
            while(j<i){
                swap(nums, j, i);
                j++;
                i--;
            }
        }
        else{
            //observing from reverse, if we move from i to j, it is sorted in ascending order
            //find index of number just greater than that at j-1
            int gr = j;
            for (int x = j; x<nums.length; x++){
                if(nums[x]>nums[j-1]){
                    gr = x;
                }
                if(nums[x]<nums[j-1]){
                    break;
                }
            }
            
            //now at gr index, nubmer is just greater than that at j-1;

            //swap elements at gr and j-1
            swap(nums, gr, j-1);

            //now sort elements from j to i in ascending order, by simply swapping first and last, then second and second last and so on (as it is already in descending order)
            while(j<i){
                swap(nums, j, i);
                j++;
                i--;
            }
        }  
        
    }

    static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    
}