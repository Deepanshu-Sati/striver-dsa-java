package ProblemsOnArrays.Hard;

/*
 * Link             : https://leetcode.com/problems/pascals-triangle/
 * Problem          : Pascal's Triangle I
 * Difficulty       : Easy
 * Approach         : Recursion
 * Time Complexity  : O(n^2)
 * Space Complexity : O(n^2)
 */

import java.util.ArrayList;
import java.util.List;

class PascalTriangleI {
    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        if(numRows < 1){
            return ans;
        }

        List<Integer> one = new ArrayList<>();
        one.add(1);
        ans.add(one);

        for(int i = 1; i<numRows; i++){
            List<Integer> prev = ans.get(i-1);
            List<Integer> curr = new ArrayList<>(i+1);
            curr.add(1);
            for(int j = 1; j <= i-1; j++){
                int element = prev.get(j-1) + prev.get(j);
                curr.add(element);
            }
            curr.add(1);
            ans.add(curr);
        }
        return ans;
    }

    public static void main(String[] args){
        int numRows = 5;
        System.out.println(generate(numRows));
    }
}