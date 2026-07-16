package Strings.Basics;

/*
 * Link             : https://leetcode.com/problems/rotate-string/
 * Problem          : Rotate String
 * Difficulty       : Easy
 * Approach         : Making s as s+s, and then finding goal within that
 * Time complexity  : O(n^2) (average case : O(n)
 * Space complexity : O(n)
 */

public class RotateString {
    static boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n!=m) return false;
        String ss = s+s;
        return ss.contains(goal);
    }

    public static void main(String[] args){
        String s = "abcde";
        String goal = "bcdea";
        System.out.println("Goal can be achieved by rotating s: "+rotateString(s, goal));
    }
}