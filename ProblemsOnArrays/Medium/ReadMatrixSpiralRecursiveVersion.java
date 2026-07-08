package ProblemsOnArrays.Medium;

/*
 * Link             : https://leetcode.com/problems/spiral-matrix/
 * Problem          : Print the matrix in spiral manner
 * Difficulty       : Medium
 * Approach         : Recursion
 * Time complexity  : O(mn)
 * Space complexity : O(min(m,n))
 */

import java.util.ArrayList;
import java.util.List;

class ReadMatrixSpiralRecursiveVersion {
    
    static List<Integer> spiralOrder(int[][] matrix) {
        
        int first_row = 0;
        int first_col = 0;
        int last_row = matrix.length-1;
        int last_col = matrix[0].length-1;

        List<Integer> list = new ArrayList<>();

        helper(matrix, first_row, first_col, last_row, last_col, list);

        return list;
    }

    static void helper(int[][] matrix, int first_row, int first_col, int last_row, int last_col, List<Integer> list){
        //base condition :
        if(first_row>last_row || first_col>last_col){
            return;
        }
        //forward
        int i = first_col;
        while(i<=last_col){
            list.add(matrix[first_row][i]);
            i++;
        }
        //down
        int j = first_row+1;
        while( j<=last_row){
            list.add(matrix[j][last_col]);
            j++;
        }
        //backwards
        if(first_row<last_row){
            int k = last_col-1;
            while(k>=first_col){
                list.add(matrix[last_row][k]);
                k--;
            }
        }
        //up
        if(first_col<last_col){
            int l = last_row-1;
            while(l>first_row){
                list.add(matrix[l][first_col]);
                l--;
            }
        }
        helper(matrix, first_row+1, first_col+1, last_row-1, last_col-1, list);
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> ans = spiralOrder(matrix);
        System.out.println(ans);
    }
    
}