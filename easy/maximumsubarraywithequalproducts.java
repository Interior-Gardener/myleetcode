// 3411. Maximum Subarray With Equal Products
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// You are given an array of positive integers nums.

// An array arr is called product equivalent if prod(arr) == lcm(arr) * gcd(arr), where:

// prod(arr) is the product of all elements of arr.
// gcd(arr) is the GCD of all elements of arr.
// lcm(arr) is the LCM of all elements of arr.
// Return the length of the longest product equivalent subarray of nums.

 

// Example 1:

// Input: nums = [1,2,1,2,1,1,1]

// Output: 5

// Explanation: 

// The longest product equivalent subarray is [1, 2, 1, 1, 1], where prod([1, 2, 1, 1, 1]) = 2, gcd([1, 2, 1, 1, 1]) = 1, and lcm([1, 2, 1, 1, 1]) = 2.

// Example 2:

// Input: nums = [2,3,4,5,6]

// Output: 3

// Explanation: 

// The longest product equivalent subarray is [3, 4, 5].

// Example 3:

// Input: nums = [1,2,3,1,4,5,1]

// Output: 5

 

// Constraints:

// 2 <= nums.length <= 100
// 1 <= nums[i] <= 10


class Solution {

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public int maxLength(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            long prod = 1;
            int g = 0;
            long l = 1;

            for (int j = i; j < nums.length; j++) {
                prod *= nums[j];
                g = gcd(g, nums[j]);
                l = (l / gcd((int) l, nums[j])) * nums[j];

                if (prod == l * g) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        return max;
    }
}
