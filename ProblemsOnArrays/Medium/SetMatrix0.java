package ProblemsOnArrays.Medium;

/*
 * Link             : https://leetcode.com/problems/set-matrix-zeroes/
 * Problem          : Set Matrix Zeroes
 * Difficulty       : Medium
 * Approach         : Linear Search
 * Time complexity  : O(n^2)
 * Space complexity : O(1)
 */

import java.util.Arrays;

public class SetMatrix0 {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        for (int[] row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }

    static void setZeroes(int[][] matrix) {
        // int[] row = new int[matrix.length]; --> matrix[..][0]
        // int[] column = new int [matrix[0].length]; --> matrix[0][..]

        int col0 = 1;
        for(int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    if(j!=0){
                        matrix[0][j] = 0;
                    }
                    else{
                        col0 = 0;
                    }
                }
            }
        }

        for(int i = 1; i<matrix.length; i++){
            for (int j = 1; j<matrix[0].length; j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0]==0){
            for(int j = 0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }

        if(col0==0){
            for(int i = 0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
