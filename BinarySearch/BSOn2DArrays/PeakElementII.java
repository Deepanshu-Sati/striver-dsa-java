package BinarySearch.BSOn2DArrays;

/*
 * Link             : https://leetcode.com/problems/find-a-peak-element-ii/
 * Problem          : Find peak element - II
 * Difficulty       : Medium
 * Approach         : Binary search and linear search
 * Time complexity  : O(NlogM) (N : no of rows, M : no of columns)
 * Space complexity : O(1)
 */

class PeakElementII {
    static int[] findPeakGrid(int[][] mat) {
        //binary search for columns
        int low = 0;
        int high = mat[0].length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int row = maxIdx(mat, mid);
            int left = mid-1>=0 ? mat[row][mid-1] : -1;
            int right = mid+1<mat[0].length ? mat[row][mid+1] : -1;
            if (mat[row][mid]>left && mat[row][mid]>right){
                return new int[]{row, mid};
            }
            else if(mat[row][mid]<left){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    static int maxIdx(int[][] matrix, int col){
        //linear search for rows
        int max_idx = 0;
        for (int i = 1; i<matrix.length; i++){
            if (matrix[i][col]>matrix[max_idx][col]){
                max_idx = i;
            }
        }
        return max_idx;
    }

    public static void main(String[] args) {
        int[][] matrix = {{48,36,35,17,48},{38,28,38,26,24},{15,9,33,32,6},{49,4,8,10,41}};
        int[] peak_index = findPeakGrid(matrix);
        int row = peak_index[0];
        int column = peak_index[1];
        System.out.println("One of the peak elements is : "+matrix[row][column]);
    }
}