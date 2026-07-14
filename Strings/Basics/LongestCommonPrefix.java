package Strings.Basics;

/*
 * Link             : https://leetcode.com/problems/longest-common-prefix/
 * Problem          : Longest common prefix
 * Difficulty       : Easy
 * Approach         : Linear scan
 * Time complexity  : O(mn) (where m = length of first string, n = length of array strs)
 * Space complexity : O(1)
 */

class LongestCommonPrefix {
    static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }

        String prefix = strs[0];

        for(int i = 0; i<strs.length; i++){
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
                if (prefix.isEmpty()){
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args){
        String[] strs = {"flower", "flow", "fly"};
        System.out.println("Longest prefix: "+longestCommonPrefix(strs));
    }
}