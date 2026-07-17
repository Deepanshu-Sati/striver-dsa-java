package Strings.Medium;

/*
 * Link             : https://leetcode.com/problems/roman-to-integer/
 * Problem          : Roman to Integer
 * Difficulty       : Medium
 * Approach         : Linear search and basic math
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */

public class RomanToInteger {
    static int romanToInt(String s) {
        int[] value = new int[128];

        value['I'] = 1;
        value['V'] = 5;
        value['X'] = 10;
        value['L'] = 50;
        value['C'] = 100;
        value['D'] = 500;
        value['M'] = 1000;

        int ans = 0;
        int prev = 0;

        for (int i = s.length()-1; i>=0; i--){
            int curr = value[s.charAt(i)];

            if(curr<prev){
                ans -= curr;
            }
            else{
                ans += curr;
            }

            prev = curr;
        }
        return ans;
    }

    public static void main(String[] args){
        String s = "XCIV";
        System.out.println(romanToInt(s));
    }
}