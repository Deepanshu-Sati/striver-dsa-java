package Strings.Medium;

/*
 * Link : https://leetcode.com/problems/reverse-words-in-a-string/
 * Problem : Reverse words in a string
 * Difficulty : Medium
 * Approach : Reverse traversal
 * Time complexity : O(n)
 * Space complexity : O(n)
 */

public class ReverseWordsInString {
    static String reverseWords(String s) {

        StringBuilder result = new StringBuilder();
        int i = s.length()-1;
        
        while(i>=0){

            //skipping through spaces
            
            while (i>=0 && s.charAt(i) == ' '){
                i--;
            }

            if (i<0){
                break;
            }

            int j = i;
            // find beginning of the word
            while(j>=0 && s.charAt(j)!=' '){
                j--;
            }

            result.append(s, j+1,i+1);
            result.append(" ");

            i=j-1;
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    public static void main(String[] args){
        String str = "   the Sky is blue    ";
        String reverse = reverseWords(str);
        System.out.println(reverse);
    }
}