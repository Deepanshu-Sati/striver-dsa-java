package ProblemsOnArrays.Medium;

/*
 * Link             : https://leetcode.com/problems/rotate-image/
 * Problem          : Rotate matrix by 90 degrees
 * Difficulty       : Medium
 * Approach         : Image of a matrix
 * Time complexity  : O(n^2)
 * Space complexity : O(1)
 */

import java.util.Arrays;

public class RotateMatrixBy90degrees {

    public static void main(String[] args){
        int[][] mat = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        for (int[] ints : mat) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println();

        rotate(mat);
        for (int[] ints : mat) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static void rotate(int[][] matrix){

        //First take image of the matrix about primary diagonal (transpose of the matrix)
        for (int i = 0; i<matrix.length; i++){
            for(int j = 0; j<i; j++){
                swap(matrix, i, j, j,i);
            }
        }

        //Now take image of matrix about the vertical axis of symmetry (reverse the rows)
        for (int k = 0; k<matrix.length; k++){
            for (int l = 0; l<(matrix.length+1)/2; l++){
                swap(matrix, k, l, k,matrix.length-1-l);
            }
        }
    }

    static void swap(int[][] matrix, int r1, int c1, int r2, int c2){
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
}
