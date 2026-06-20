package Strings.Medium;

/*
 * Link             : https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 * Problem          : Maximum nesting depth of parentheses
 * Difficulty       : Easy-Medium
 * Approach         : Linear Search
 * Time complexity  : O(N)
 * Space complexity : O(1)
 */

class MaxNestingDepth {
    static int maxDepth(String s) {
        int depth = 0;
        int open = 0;
        for (int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                open++;
                if (open>depth){
                    depth = open;
                }
            }
            else if(s.charAt(i)==')'){
                open--;
            }
        }
        return depth;
    }

    public static void main(String[] args){
        String str = "(1+(2*3)+((8)/4))+1";
        System.out.println("Maximum nesting depth : "+maxDepth(str));
    }
}