package Strings.Basics;

/*
 * Link             : https://leetcode.com/problems/remove-outermost-parentheses/
 * Problem          : Remove outermost parentheses
 * Difficulty       : Easy
 * Approach         : Linear Scan
 * Time complexity  : O(N)
 * Space complexity : O(1)
 */
class Solution {
    static String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int level = 0;
        for (char ch : s.toCharArray()){            
            if(ch=='('){
                if (level>0){
                    result.append(ch);
                }
                level++;
            }
            else{
                level--;
                if(level>0){
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        String par = "((())()((())))(())";
        System.out.println(removeOuterParentheses(par));
    }
}