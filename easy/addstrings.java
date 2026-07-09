// 415. Add Strings
// Easy
// Topics
// premium lock icon
// Companies
// Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

// You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
// Example 1:
// Input: num1 = "11", num2 = "123"
// Output: "134"
// Example 2:
// Input: num1 = "456", num2 = "77"
// Output: "533"
// Example 3:
// Input: num1 = "0", num2 = "0"
// Output: "0"
// Constraints:
// 1 <= num1.length, num2.length <= 104
// num1 and num2 consist of only digits.
// num1 and num2 don't have any leading zeros except for the zero itself.
class Solution {
    // public static String addStrings(String num1, String num2) {
    //     int n1=0,n2=0;

    //     for (char c : num1.toCharArray()){
    //         int digit = c - '0';
    //         n1 = ((n1*10)+digit);
    //     }
    //     for (char c : num2.toCharArray()){
    //         int digit = c - '0';
    //         n2 = ((n2*10)+digit);
    //     }
    //     int result = n1 + n2;
    //     return Integer.toString(result);
    // }
    public static String addStrings(String num1, String num2) {

        // StringBuilder sb = new StringBuilder();
        // sb.append(num1);
        // sb.reverse();
        // String concat = sb + num2;
        // int i = 0 , j = concat.length() - 1;
        // StringBuilder result = new StringBuilder();
        // int carry=0;
        // while(i<sb.length() && j > num2.length()-1) {
        //     char c1 = concat.charAt(i);
        //     char c2 = concat.charAt(j);
        //     c1-= '0';
        //     c2-='0';
        //     int append=0;
        //     if((c1+c2+carry)>9){
        //         carry = 1;
        //         append = (c1+c2+carry)%10;
        //         result.insert(0,append);
        //         append = 0;
        //     }
        //     else{
        //             append = (c1+c2+carry);
        //             result.insert(0,append);
        //             append = 0;
        //             carry = 0;
        //     }
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int c1 = num1.charAt(i) - '0';
            int c2 = num2.charAt(j) - '0';
            int append;
            if ((c1 + c2 + carry) >= 10) {
                append = (c1 + c2 + carry) % 10;
                result.insert(0, append);
                carry = 1;
            } else {
                append = (c1 + c2 + carry);
                result.insert(0, append);
                carry = 0;
            }

            i--;
            j--;
            // System.out.println(result);

        }
        // System.out.println("outside while"+ " i>" + i + " j>"+j);
        if (i >= 0) {
            while (i >= 0) {
                // result.insert(0, num1.charAt(i));
                // i--;
                int c = num1.charAt(i) - '0';
                if(c+carry>=10){
                    int append = (c+carry)%10;
                    result.insert(0, append);
                    carry=1;
                    i--;
                }
                else{
                    result.insert(0,(num1.charAt(i)-'0'+carry));
                    carry=0;
                    i--;
                }
            }
        } else if (j >= 0) {
            while (j >= 0) {
                // result.insert(0, num2.charAt(j));
                // j--;

                int c = num2.charAt(j) - '0';
                if(c+carry>=10){
                    int append = (c+carry)%10;
                    result.insert(0, append);
                    carry=1;
                    j--;
                }
                else{
                    result.insert(0,(num2.charAt(j)-'0'+carry));
                    carry=0;
                    j--;
                }
            }
        }
        if(carry == 1){
            result.insert(0,"1");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String num1 = "6", num2 = "501";

        System.out.println(addStrings(num1, num2));
    }
}
