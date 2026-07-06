package Recursion.GetAStrongHold;

/*
 * Link             : https://leetcode.com/problems/count-good-numbers/
 * Problem          : Count good numbers
 * Difficulty   `   : Medium
 * Approach         : Binary exponentiation and basics of Combinatorics
 * Time complexity  : O(logN)
 * Space complexity : O(1)
 * NOTE : This problem can be solved by recursion (pow function) but it would take same time complexity but extra (logN) space!
 */

class CountGoodNumbers {
    static final long MOD = 1000000007;
    static int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = (n)/2;

        return (int)((pow(5, even) * pow(4, odd))%MOD);
        
    }
    static long pow(long base, long exp){
        long ans = 1;

        while(exp>0){
            if((exp&1)==1){
                //rightmost digit in binary representation is 1, i.e, exponent is not a power of 2.
                ans = (ans*base)%MOD;
            }
            base = (base*base)%MOD;

            exp/=2;
        }
        return ans;
    }

    public static void main(String[] args){
        long n = 803920202;
        System.out.println("Number of good numbers : "+ countGoodNumbers(n));

    }
}