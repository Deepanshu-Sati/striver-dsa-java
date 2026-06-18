package BinarySearch.BSOn2DArrays;

/*
 * Link             : https://takeuforward.org/arrays/find-the-row-with-maximum-number-of-1s
 * Problem          : Maximum number of 1s
 * Difficulty       : Easy
 * Approach         : Linear and binary search
 * Time complexity  : O(NlogM)  //(N : number of rows, M : number of columns)
 * Space complexity : O(1)
 */

public class Max1s {
    public static void main(String[] args) {
        int[][] mat = {{0,0,1}, {0,1,1}, {1,1,1}};
        System.out.println("Row index of row with maximum number of 1s is : "+rowWithMax1s(mat));
    }

    // Function to find the lower bound (first index where value == 1)
    static int lowerBound(int[] arr) {
            int low = 0, high = arr.length - 1;
            int ans = arr.length;  // Default value if no index is found with element value one.

            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[mid] == 1) {
                    ans = mid;        // Possible answer found
                    high = mid - 1;   // Try to find a smaller index
                } else {
                    low = mid + 1;    // Move right
                }
            }
            return ans;  // Index of first element == 1
    }

    // Function to return index of the row with the maximum number of 1s
    static int rowWithMax1s(int[][] matrix) {
        int cnt_max = 0;  // Keeps track of the maximum number of 1s found so far
        int index = -1;// Stores index of the row with maximum 1s

        int n = matrix.length; //number of rows
        int m = matrix[0].length; //number of columns

        // Iterate over all rows
        for (int i = 0; i < n; i++) {
            // Count of 1s = total columns - index of first 1 (lower bound)
            int cnt_ones = m - lowerBound(matrix[i]);
            if (cnt_ones > cnt_max) {
                cnt_max = cnt_ones;
                index = i;
            }
        }
        return index;  // Return row index with maximum 1s
    }
}
