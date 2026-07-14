package Strings.Basics;

/*
 * Link             : https://leetcode.com/problems/largest-odd-number-in-string/
 * Problem          : Largest Odd Number in a String
 * Difficulty       : Easy
 * Approach         : Linear scan
 * Time Complexity  : O(n) (where n is the length of the string)
 * Space Complexity : O(1)
 */

class LargestOddNumber {
    static String largestOddNumber(String num) {
        int i = num.length()-1;
        while(i>=0){
            if ((int)(num.charAt(i))%2 != 0){
                break;
            }
            i--;
        }
        
        return (num.substring(0,i+1));
    }

    public static void main(String[] args){
        String num = "2910192820112234";
        System.out.println(largestOddNumber(num));
    }
}