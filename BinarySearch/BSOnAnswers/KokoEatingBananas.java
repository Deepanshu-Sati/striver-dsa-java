package BinarySearch.BSOnAnswers;

/*
 * Link             : https://leetcode.com/problems/koko-eating-bananas/
 * Problem          : Koko eating bananas
 * Difficulty       : Medium
 * Approach         : Binary search
 * Time complexity  : O(n*log(maxPile))
 * Space complexity : O(1)
 */

class KokoEatingBananas {
    static int minEatingSpeed(int[] piles, int h) {
        int biggest_pile = piles[0];
        int total_bananas = 0;


        for (int i = 0; i<piles.length; i++){
            if (piles[i]>biggest_pile) {
                biggest_pile = piles[i];
            }
            total_bananas += piles[i];
        }

        int min_k_noCond;
        if(total_bananas%h !=0){
            min_k_noCond = 1+ total_bananas/h;
        }
        else{
            min_k_noCond = total_bananas/h;
        }
        //total_bananas value may overflow in case of too big piles, in that case, simply using 1 for min_k_noCond makes more sense


        //to find minimum k for given condition we will apply binary search from min_k_noCond to biggest_pile

        int start = min_k_noCond;
        int end = biggest_pile;
        int k=start;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(timeTaken(piles, mid)<=h){
                //possible answer, but check for lower values
                k = mid;
                end = mid-1;

            }
            else{
                //increase speed
                start = mid+1;
            }
            
        }
        return k;  
    }

    static long timeTaken(int[] piles, int k){
        //time taken to finish bananas with max speed k
        long hrs = 0;
        for (int i = 0; i<piles.length; i++){
            if (piles[i]%k!=0){
                hrs += piles[i]/k + 1;
            }
            else{
                hrs += piles[i]/k;
            }    
        }
        return hrs;
    }

    public static void main(String[] args){
        int[] piles = {332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
        int h = 823855818;
        System.out.println("Minimum speed : "+minEatingSpeed(piles, h));
    }

}