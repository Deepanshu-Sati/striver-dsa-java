package Strings.Basics;

/*
 * Link             : https://leetcode.com/problems/valid-anagram/
 * Problem          : Check if two strings are anagram of each other
 * Difficulty       : Easy
 * Approach         : HashMaps
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */

class Anagram {

    public static void main(String[] args) {
        String s = "abc";
        String t = "bca";
        System.out.println(isAnagram(s, t));
    }


    static boolean isAnagram(String s, String t) {
        // Case: when both of the strings have different lengths
        if (s.length() != t.length()){
            return false;
        } 
            
        // Initialize a frequency array to store character counts
        int[] freq = new int[26];

        // Count frequency of each character in s
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Decrement frequency for each character in t
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0)  // If any frequency is non-zero, they are not anagrams
                return false;
        }

        return true;  // The strings are anagrams
    }
}