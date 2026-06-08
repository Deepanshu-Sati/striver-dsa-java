package ProblemsOnArrays.Easy;

/*
 * Problem          : Union of Two Sorted Arrays
 * Difficulty       : Easy
 * Approach         : Two pointers, and comparison
 * Time complexity  : O(M+N)
 * Space complexity : O(M+N) (if we include the final answer list, otherwise O(1))
 */

import java.util.ArrayList;

import java.util.List;


public class UnionOfSortedArr {
    static List<Integer> union(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<m && j<n){
            int val;
            //selecting element to be added
            if(arr1[i]<arr2[j]){
                val = arr1[i];
                i++;
            }
            else if(arr1[i] == arr2[j]){
                val = arr1[i];
                i++;
                j++;
            }
            else{//arr1[i]>arr2[j]
                val = arr2[j];
                j++;
            }

            if (list.isEmpty() || list.getLast() != val){
                list.add(val);
            }
        }

        // if arr1 has some remaining elements
        while(i<m){
            if(list.isEmpty() || list.getLast() != arr1[i]){
                list.add(arr1[i]);
            i++;
            }
        }

        //if arr2 has some remaining elements
        while(j<n){
            if(list.isEmpty() || list.getLast() != arr2[j]){
                list.add(arr2[j]);
            j++;
            }
        }
        return list;
    }

    public static void main(String[] args){
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,5,9,10,12};
        System.out.println(union(arr1, arr2));
    }
}
