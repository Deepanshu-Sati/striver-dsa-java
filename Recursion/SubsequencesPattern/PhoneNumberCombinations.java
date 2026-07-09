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

class PhoneNumberCombinations {
    static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        return numpad("", digits);
    }

    static List<String> numpad(String p, String up){
        if (up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();
        int digit = up.charAt(0)-'0';

        if(digit>=2 && digit<=6){
            for(int i = (digit-2)*3; i<(digit-1)*3; i++){
                char ch = (char)('a' + i);
                list.addAll(numpad(p+ch, up.substring(1)));
            }
        }

        else if(digit==7){
            for(int i = (digit-2)*3; i<=(digit-1)*3; i++){
                char ch = (char)('a' + i);
                list.addAll(numpad(p+ch, up.substring(1)));
            }
        }

        else if(digit==8){
            for(int i = (digit-2)*3+1; i<=(digit-1)*3; i++){
                char ch = (char)('a' + i);
                list.addAll(numpad(p+ch, up.substring(1)));
            }
        }

        else{
            for(int i = ((digit-2)*3)+1; i<=((digit-1)*3)+1; i++){
                char ch = (char)('a' + i);
                list.addAll(numpad(p+ch, up.substring(1)));
            }
        }

        return list;
    }

    public static void main(String[] args){
        String digits = "7239";
        System.out.println(letterCombinations(digits));
    }
}