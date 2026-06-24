package BinarySearch.BSOnAnswers;

/*
 * Link             : https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * Problem          : Minimum days to make 'm' bouquets
 * Difficulty       : Medium
 * Approach         : Binary Search
 * Time complexity  : O(nlogR), where R = max(bloomDay) - min(bloomDay)
 * Space complexity : O(1)
*/

class mBouquets {

    public static void main(String[] args){
        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2;
        int k = 3;
        int min_days = minDays(bloomDay, m, k);
        System.out.printf("It takes minimum %d days to make %d bouquets of %d (adjacent) flowers each.", min_days, m, k);
    }
    static int minDays(int[] bloomDay, int m, int k) {

        //if required number of flowers is greater than the number of flowers available, we can't make the required number of bouquets
        if ((long)m * k > bloomDay.length) {
           return -1;
        }

        int min = bloomDay[0];
        int max = bloomDay[0];
        for (int n_days : bloomDay){
            if (n_days>max) max = n_days;
            if (n_days<min) min = n_days;
        }

        //apply binary search to find minimum number of days

        int start = min;
        int end = max;
        int minimum_days = -1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(isPossible(bloomDay, m, k, mid)){
                // required bouquets can be formed in 'mid' number of days
                minimum_days = mid;
                // check for lesser time
                end = mid-1;
            }
            else{
                // required bouquets can't be formed in 'mid' number of days
                // check for more time
                start = mid+1;
            }
        }
        return minimum_days;
    }

    static boolean isPossible(int[] bloomDay, int m, int k, int days_given){
        boolean answer = false;
        int i = 0;
        int count = 0;
        
        while(i <= bloomDay.length-k){
            //checking in blocks, for whether a block can be used to make bouquet of k flowers withing days_given
            int j = i;
            boolean loop_complete = false;
            while(j<=i+k-1){
                if(bloomDay[j]>days_given){
                    //if even a single flower in a block takes more time to bloom than days_given, the block can't be used
                    loop_complete = false;
                    break;
                }
                else{
                    //check for next flower's blooming time
                    loop_complete = true;
                    j++;
                }
            }
            if (loop_complete){
                // the block we just checked is can be used to make a bouquet of k flowers within days given
                count++;
                // now check the next flower just after this block
                i += k;
            }
            else{
                // the block we just checked can't be used to make a bouquet, as the flower at j index takes more time than the days_given
                // so we check for new block just after the flower at jth index.
                i = j+1;
            }

            if (count == m){
                // if we have made m bouquets, no need to check further.
                return true;
            }
        }

        //  count didn't reach m, so we can say it is not possible to make m bouquets in days_given
        return false;
    }

    //following simpler function can also be used instead of isPossible.
    static boolean isPossible2(int[] bloomDay, int m, int k, int days_given) {

        int flowers = 0;
        int bouquets = 0;

        for (int bloom : bloomDay) {

            if (bloom <= days_given) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            }
            else {
                flowers = 0;
            }

            if (bouquets >= m) {
                return true;
            }
        }

        return false;
    }
}