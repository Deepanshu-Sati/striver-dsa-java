package Recursion.SubsequencesPattern;

/*
 * Link             : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Problem          : Letter Combinations of a Phone Number
 * Difficulty       : Medium-Hard
 * Approach         : Recursion
 * Time complexity  : O(n*4^n)
 * Space complexity : O(n)
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    static String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()){
            return ans;
        }
        numpad(new StringBuilder(), digits, 0, ans);
        return ans;
    }

    static void numpad(StringBuilder processed, String digits, int index, List<String> ans){
        if(index == digits.length()){
            ans.add(processed.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String str = map[digit];

        for(int i = 0; i<str.length(); i++){
            numpad(processed.append(str.charAt(i)), digits, index+1, ans);
            processed.deleteCharAt(processed.length()-1);
        }
    }

    public static void main(String[] args){
        String digits = "7239";
        System.out.println(letterCombinations(digits));
    }
}