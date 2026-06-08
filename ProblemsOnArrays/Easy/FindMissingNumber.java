package ProblemsOnArrays.Easy;

/*
 * Link             : https://www.geeksforgeeks.org/dsa/find-the-missing-number/
 * Problem          : Find missing number
 * Difficulty       : Easy-Medium
 * Approach         : Cycle Sort
 * Time complexity  : O(N)
 * Space complexity : O(1)
 */

class FindMissingNumber {

    static int missingNum(int[] arr) {

        int i = 0;
        //cycle sort
        while(i<arr.length){
            int corr_idx = arr[i]-1;
            if (corr_idx < arr.length){
                if(arr[i]!=arr[corr_idx]){
                    int temp = arr[i];
                    arr[i] = arr[corr_idx];
                    arr[corr_idx] = temp;
                }
                else{
                    i++;
                }
            }
            else{
                i++;
            }
        }
        //the element which is not present at the correct (supposed) index, is answer
        for (int j = 0; j<arr.length; j++){
            if (arr[j] != j+1){
                return j+1;
            }
        }

        // if all the elements in range are present, return next integer
        return arr.length+1;
    }

    public static void main(String[] args){
        int[] arr = {2,5,6,3,4};
        System.out.println("Missing element is: "+ missingNum(arr));
    }
}