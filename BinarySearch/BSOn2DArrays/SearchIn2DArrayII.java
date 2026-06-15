package BinarySearch.BSOn2DArrays;

/*
 * Link             : https://leetcode.com/problems/search-a-2d-matrix-ii/
 * Problem          : Search in 2D arrays - II
 * Difficulty       : Medium
 * Approach         : Staircase Search
 * Time complexity  : O(m+n)
 * Space complexity : O(1)
 */

class SearchIn2DArrayII {
    static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col>=0){
            if (target == matrix[row][col]){
                return true;
            }
            else if(target > matrix[row][col]){
                row ++;
            }
            else{
                col --;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix = {{2,7,9},{4,8,10},{6,11,14}};
        int target = 12;
        System.out.println("Target exists in matrix : "+searchMatrix(matrix, target));
    }
}