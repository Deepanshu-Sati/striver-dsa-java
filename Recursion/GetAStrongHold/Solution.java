package Recursion.GetAStrongHold;

class Solution {
    public double myPow(double x, int n) {
        //n is negative
        if (n < 0) {
            long nn = n;
            return 1.0 / power(x, -nn);
        }
        //n is non-negative
        return power(x, n);      
    }

    static double power(double x, long n){
        if (n == 0) return 1.0;
        
        // anything raised to 1 is itself
        if (n == 1) return x;
        
        // n is even
        if (n % 2 == 0) {
            // Recursive call: square the base and halve the exponent
            return power(x * x, n / 2);
        }
        
        // n is odd
        // Recursive call: multiply base once and reduce exponent by 1
        return x * power(x*x, (n - 1)/2);
    }
}