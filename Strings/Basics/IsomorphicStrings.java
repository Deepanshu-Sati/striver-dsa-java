package Strings.Basics;

/*
 * Link             : https://leetcode.com/problems/isomorphic-strings/
 * Problem          : Isomorphic Strings
 * Difficulty       : Easy
 * Approach         : Hashing
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */

public class IsomorphicStrings {
    static boolean isIsomorphic(String s, String t) {

        int[] m1 = new int[256];
        int[] m2 = new int[256];

        int n = s.length();

        for(int i = 0; i<n; i++){
            if(m1[s.charAt(i)] == m2[t.charAt(i)]){
                m1[s.charAt(i)] = i+1;
                m2[t.charAt(i)] = i+1;
            }
            else{
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        String s = "egg";
        String t = "add";

        System.out.println("Strings are isomorphic: "+ isIsomorphic(s, t));
    }
}