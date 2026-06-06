package ProblemsOnArrays.Easy;

/*
time complexity  : O(N)
space complexity : 1 (constant)
approach         : linear search
difficulty       : easy
 */

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] nums = {45,66,21,89,91};
        int idx = secondLargest(nums);
        if(idx == -1){
            System.out.println("Array should have at least 2 elements!");
        }
        else{
            System.out.println("Second largest element : "+ nums[idx]);
        }
    }

    static int secondLargest(int[] nums) {
        if (nums == null || nums.length < 2) {
            //making sure that the given array has at least 2 elements so that we can find second largest element
            return -1;
        }
        int sLargest_idx = 0;
        int largest_idx = 0;
        for (int i = 0; i < nums.length; i++){

            if (nums[largest_idx] < nums[i]){
                sLargest_idx = largest_idx;
                //swapping the older largest element's index to second largest, when we find larger element
                largest_idx = i;

            }
        }
        return sLargest_idx;
    }
}