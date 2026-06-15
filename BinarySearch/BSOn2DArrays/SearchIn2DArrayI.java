package BinarySearch.BSOn2DArrays;

/*
 * Link             : https://leetcode.com/problems/search-a-2d-matrix/
 * Problem          : Search in 2D arrays - I
 * Difficulty       : Medium
 * Approach         : Binary search
 * Time complexity  : O(logMN)
 * Space complexity : O(1)
 */

class SearchIn2DArrayI {
    static boolean searchMatrix(int[][] matrix, int target) {
        int row_start = 0;
        int row_end = matrix.length-1;

        int col_start = 0;
        int col_end = matrix[0].length-1;
        int col_mid = col_start + (col_end-col_start)/2;

        //if there is only one row in the matrix, apply simple binary search
        if (row_end == 0){
            return bsHorizontal(matrix, target, 0, 0, col_end);
        }

        //otherwise, reduce the whole matrix to just two rows where finding the target is possible
        while(row_start < row_end-1){
            int row_mid = row_start + (row_end-row_start)/2;
            if (target == matrix[row_mid][col_mid]){
                return true;
            }
            else if (target > matrix[row_mid][col_mid]){
                row_start = row_mid;
            }
            else{
                row_end = row_mid;
            }
        }
        //now our search space is just two rows, we can divide it further into:
        //middle column two elements
        if (matrix[row_start][col_mid]==target){
            return true;
        }
        if (matrix[row_end][col_mid]==target){
            return true;
        }

        boolean isfound = false;
        //top left row
        if (target<matrix[row_start][col_mid]){
            isfound = bsHorizontal(matrix, target, row_start, col_start, col_mid-1);
        }
        //top right row
        else if (target>matrix[row_start][col_mid] && target<=matrix[row_start][col_end]){
            isfound = bsHorizontal(matrix, target, row_start, col_mid+1, col_end);
        }
        //bottom left row
        else if (target>=matrix[row_end][col_start] && target<matrix[row_end][col_mid]){
            isfound = bsHorizontal(matrix, target, row_end, col_start, col_mid-1);
        }
        //bottom right row
        else{
            isfound = bsHorizontal(matrix, target, row_end, col_mid+1, col_end);
        }
        return isfound;

        
    }
    static boolean bsHorizontal(int[][] nums, int target, int row, int col_s, int col_e){
        while(col_s<=col_e){
            int col_m = col_s + (col_e - col_s)/2;
            if (nums[row][col_m]==target){
                return true;
            }
            else if (nums[row][col_m]<target){
                col_s = col_m+1;     
            }
            else{
                col_e = col_m-1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] matrix= {{1,2,3}, {4,5,6}, {7,8,9}};
        int target = 0;
        System.out.println("Target exits in the matrix : "+searchMatrix(matrix, target));
    }
}