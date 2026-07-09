
// Code
// Accepted
// Accepted
// Testcase
// Testcase
// Test Result
// 50. Pow(x, n)
// Solved
// Medium
// Topics
// premium lock icon
// Companies
// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

// Example 1:

// Input: x = 2.00000, n = 10
// Output: 1024.00000
// Example 2:

// Input: x = 2.10000, n = 3
// Output: 9.26100
// Example 3:

// Input: x = 2.00000, n = -2
// Output: 0.25000
// Explanation: 2-2 = 1/22 = 1/4 = 0.25

// Constraints:

// -100.0 < x < 100.0
// -231 <= n <= 231-1
// n is an integer.
// Either x is not zero or n > 0.
// -104 <= xn <= 104

class Solution {
    // public double myPow(double x, int n) {
    // if(n == 0) {
    // return (double)1;
    // }
    // if(n == 1) {
    // return x;
    // }
    // if(n == -1) {
    // return 1/x;
    // }
    // boolean negative;
    // if(n < 0) {
    // negative = true;
    // n *= -1;
    // }
    // else negative = false;
    // double res =x;
    // return power(x,n,negative,res);
    // }

    public double myPow(double x, int n) {
        //     if(negative) return 1/res;
        //     return res;
        // }
        // res *= x;
        // // if(negative) return power(x, n+1, negative, res);
        // return power(x, n-1, negative, res);
        // if(n == 0) {
        //     return (double)1;
        // }
        // if(n == 1) {
        //     return x;
        // }
        // if(n == -1) {
        //     return 1/x;
        // }
        boolean negative = false;
        if( n < 0) {
            negative = true;
            n*=-1;
        }
        String binary = Integer.toBinaryString(n);
        double res = 1;

        for(int i = binary.length() -1 ; i >= 0 ; i--) {
            if(binary.charAt(i) == '1') {
                res *= x;
            }
            x *= x;
        }
        if(negative) return 1/res;
        else return res;
    }

    public static void main(String[] args) {
        // double x = 0;
        Solution sol = new Solution();

        // System.out.println(Math.pow(2, -200000000));
        System.out.println(sol.myPow(2, -200000000));
        // System.out.println(sol.myPow(2, 10));
    }
}