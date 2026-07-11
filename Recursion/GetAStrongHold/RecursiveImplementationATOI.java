package Recursion.GetAStrongHold;

/*
 * Link             : https://leetcode.com/problems/string-to-integer-atoi/description/
 * Problem          : Recursive Implementation of atoi()
 * Difficulty       : Medium
 * Approach         : Recursion
 * Time complexity  : O(n)
 * Space complexity : O(1)
 */

class RecursiveImplementationATOI {
    public static void main(String[] args) {
        System.out.println(myAtoi("    -42*__89"));
    }
    static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        if(s.charAt(0)=='-'){
            long ans = -1*(conversion(0, s, 1));
            if(ans<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            else{
                return (int)(ans);
            }
        }
        if (s.charAt(0)=='+'){
            long ans = conversion(0, s, 1);
            if(ans>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            else{
                return (int)ans;
            }
        }
        if(s.charAt(0)>='0' && s.charAt(0) <='9'){
            long ans = conversion(0, s, 0);
            if(ans>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }

            return (int)ans;
        }

        return 0;

    }

    static long conversion(long p, String up, int index){

        if (index >= up.length() || (!(up.charAt(index)>='0' && up.charAt(index)<='9'))){
            return p;
        }

        int digit = up.charAt(index) - '0';
        p = p*10 + digit;

        if(p>=(long)Integer.MAX_VALUE+1){
            return p;
        }

        return conversion(p, up, index+1);
    }
}
