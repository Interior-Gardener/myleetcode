// 3536. Maximum Product of Two Digits
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// You are given a positive integer n.

// Return the maximum product of any two digits in n.

// Note: You may use the same digit twice if it appears more than once in n.

// Example 1:

// Input: n = 31

// Output: 3

// Explanation:

// The digits of n are [3, 1].
// The possible products of any two digits are: 3 * 1 = 3.
// The maximum product is 3.
// Example 2:

// Input: n = 22

// Output: 4

// Explanation:

// The digits of n are [2, 2].
// The possible products of any two digits are: 2 * 2 = 4.
// The maximum product is 4.
// Example 3:

// Input: n = 124

// Output: 8

// Explanation:

// The digits of n are [1, 2, 4].
// The possible products of any two digits are: 1 * 2 = 2, 1 * 4 = 4, 2 * 4 = 8.
// The maximum product is 8.

// Constraints:

// 10 <= n <= 109

class Solution {
    public int maxProduct(int n) {
        int maxdigit = Integer.MIN_VALUE;
        int secondmax = Integer.MIN_VALUE;

        int len = getlen(n);

        for (int i = 0; i < len; i++) {
            int digit = n % 10;
            System.out.println(digit);
            n /= 10;
            if (digit > maxdigit) {
                secondmax = maxdigit;
                maxdigit = digit;
                continue;
                // System.out.println(maxdigit + " max");
                // System.out.println(secondmax + " secmax");
            }
            if(digit > secondmax) {
                secondmax = digit;
            }
        }

        return maxdigit * secondmax;
    }

    public int getlen(int n) {
        int len = 0;
        int temp = n;
        while (temp >= 1) {
            len++;
            temp /= 10;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(22));
    }
}