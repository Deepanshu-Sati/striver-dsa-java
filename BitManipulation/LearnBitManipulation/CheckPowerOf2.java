package BitManipulation.LearnBitManipulation;

/*
 * Link             : https://leetcode.com/problems/power-of-two/
 * Problem          : Power of 2
 * Difficulty       : Easy
 * Approach         : Bit Manipulation
 * Time complexity  : O(1)
 * Space complexity : O(1)
 */

public class CheckPowerOf2 {
    public static void main(String[] args){
        int n = 64;
        System.out.println("Is power of two : "+isPowerOfTwo(n));
    }

    static boolean isPowerOfTwo(int n) {
        return n>0 && (n & (n-1)) == 0;
    }
}
