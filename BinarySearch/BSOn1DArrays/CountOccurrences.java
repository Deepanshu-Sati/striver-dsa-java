package BinarySearch.BSOn1DArrays;

/*
 * Problem : Find number of occurrences of an element in a sorted array.
 * Difficulty : Easy-Medium
 * Approach : Binary Search (similar to FirstAndLastOccurrence problem)
 * Time complexity : O(logN)
 * Space complexity : O(1)
 */


import static BinarySearch.BSOn1DArrays.FirstAndLastOccurrence.searchRange;

public class CountOccurrences {
    public static void main(String[] args){
        int[] nums = {1,3,3,3,4,5,6};
        int target = 3;
        int count = countOccurrences(nums, target);
        System.out.println("Number of occurrences of target element : "+count);
    }

    static int countOccurrences(int[] nums, int target){
        int[] range = searchRange(nums, target); //searchRange function provides the first and last occurrences of the element.
        if (range[0] == -1) return 0;
        return range[1] - range[0] + 1;
    }
}
