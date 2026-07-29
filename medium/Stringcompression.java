// // 443. String Compression
// // Medium
// // Topics
// // premium lock icon
// // Companies
// // Hint
// // Given an array of characters chars, compress it using the following algorithm:

// // Begin with an empty string s. For each group of consecutive repeating characters in chars:

// // If the group's length is 1, append the character to s.
// // Otherwise, append the character followed by the group's length.
// // The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

// // After you are done modifying the input array, return the new length of the array.

// // You must write an algorithm that uses only constant extra space.

// // Note: The characters in the array beyond the returned length do not matter and should be ignored.

// // Example 1:

// // Input: chars = ["a","a","b","b","c","c","c"]
// // Output: 6
// // Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
// // After modifying the input array in-place, the first 6 characters of chars should be ["a","2","b","2","c","3"].
// // Example 2:

// // Input: chars = ["a"]
// // Output: 1
// // Explanation: The only group is "a", which remains uncompressed since it is a single character.
// // After modifying the input array in-place, the first character of chars should be ["a"].
// // Example 3:

// // Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
// // Output: 4
// // Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
// // After modifying the input array in-place, the first 4 characters of chars should be ["a","b","1","2"].

// // Constraints:

// // 1 <= chars.length <= 2000
// // chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.

// class Solution {
//     public int compress(char[] chars) {
//         if (chars.length == 1)
//             return 1;
//         // HashMap<Character, Integer> map = new HashMap<>();
//         // for (char c : chars) {
//         //     if (map.get(c) == null) {
//         //         map.put(c, 1);
//         //     } else {
//         //         map.put(c, map.get(c) + 1);
//         //     }
//         // }
//         // int count = 0;
//         // for (char c : map.keySet()) {
//         //     if (map.get(c) > 9 && map.get(c) < 100) {
//         //         count = count + 3;
//         //     } else if (map.get(c) > 99 && map.get(c) < 1000) {
//         //         count = count + 4;
//         //     } else if (map.get(c) > 1 && map.get(c) < 10) {
//         //         count = count + 2;
//         //     } else {
//         //         count = count + 1;
//         //     }
//         // }
//         int i = 0, j = 0, freq = 0, update = 0;
//         while (j < chars.length && i < chars.length) {
//             if (chars[i] == chars[j]) {
//                 j++;
//                 freq++;
//             } else if (chars[i] != chars[j] || j == chars.length) {
//                 chars[update] = chars[i];
//                 update++;
//                 if (freq < 10) {
//                     while (freq > 1) {
//                         // chars[i] = (char) ((freq % 10) + '0');
//                         // freq /= 10;
//                         // i++;
//                         chars[update] = (char) ((freq % 10) + '0');
//                         freq /= 10;
//                         update++;
//                     }
//                     while (i != j) {
//                         i++;
//                     }
//                 } else {
//                     while (freq >= 1) {
//                         // chars[i] = (char) ((freq % 10) + '0');
//                         // freq /= 10;
//                         // i++;
//                         int num = freq/(int)Math.pow(10,getlen(freq)-1);
//                         chars[update] = (char) ((num) + '0');
//                         freq -= (int)Math.pow(10,getlen(freq)-1) ;
//                         update++;
//                     }
//                     while (i != j) {
//                         i++;
//                     }
//                 }
//             }
//         }
//         // System.out.print(count + "<count");
//         // return count;
//         return 0;
//     }
//     public int getlen(int num) {
//         int len = 0;
//         while(num >= 1) {
//             len++;
//             num = num / 10;
//         }
//         return len;
//     }
// }

// import java.util.*;
// class Solution {
//     public int compress(char[] chars) {
//         if (chars.length == 1)
//             return 1;
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (char c : chars) {
//             if (map.get(c) == null) {
//                 map.put(c, 1);
//             } else {
//                 map.put(c, map.get(c) + 1);
//             }
//         }
//         int count = 0;
//         for (char c : map.keySet()) {
//             if (map.get(c) > 9 && map.get(c) < 100) {
//                 count = count + 3;
//             } else if (map.get(c) > 99 && map.get(c) < 1000) {
//                 count = count + 4;
//             } else if (map.get(c) > 1 && map.get(c) < 10) {
//                 count = count + 2;
//             } else {
//                 count = count + 1;
//             }
//         }
//         int i = 0, j = 0, freq = 0, update = 0;
//         while (j < chars.length && i < chars.length) {
//             if (chars[i] == chars[j]) {
//                 j++;
//                 freq++;
//             } else if (chars[i] != chars[j] || j == chars.length) {
//                 chars[update] = chars[i];
//                 update++;
//                 if (freq < 10) {
//                     while (freq > 1) {
//                         chars[update] = (char) ((freq % 10) + '0');
//                         freq /= 10;
//                         update++;
//                     }
//                     while (i != j) {
//                         i++;
//                     }
//                 } else {
//                     while (freq >= 1) {
//                         int num = freq/(int)Math.pow(10,getlen(freq)-1);
//                         chars[update] = (char) ((num) + '0');
//                         freq -= (int)Math.pow(10,getlen(freq)-1) ;
//                         update++;
//                     }
//                     while (i != j) {
//                         i++;
//                     }
//                 }
//             }
//             if(freq > 1) {
//                 chars[update] = chars[i];
//                 update++;
//                 if (freq < 10) {
//                     while (freq > 1) {
//                         chars[update] = (char) ((freq % 10) + '0');
//                         freq /= 10;
//                         update++;
//                     }
//                 }
//                 else {
//                     while (freq >= 1) {
//                         int num = freq/(int)Math.pow(10,getlen(freq)-1);
//                         chars[update] = (char) ((num) + '0');
//                         freq -= (int)Math.pow(10,getlen(freq)-1) ;
//                         update++;
//                     }
//                 }
//             }
//         }
//         System.out.print(count + "<count");
//         return count;
//     }

//     public int getlen(int num) {
//         int len = 0;
//         while (num >= 1) {
//             len++;
//             num = num / 10;
//         }
//         return len;
//     }
// }

// class Solution {
//     public int compress(char[] chars) {
//         if (chars.length == 1)
//             return 1;
//         int freq = 0;
//         int i = 0;
//         int j = 0;
//         int n = chars.length;
//         while (j < n) {
//             if (chars[i] == chars[j]) {
//                 freq++;
//                 j++;
//                 continue;
//             } else if (chars[i] != chars[j]) {
//                 if (freq > 1) {
//                     for (char c : Integer.toString(freq).toCharArray()) {
//                         chars[++i] = c;
//                     }
//                     freq = 0;
//                     int temp = j;
//                     int temp1 = i;
//                     while (temp < chars.length) {
//                         temp1++;
//                         chars[temp1] = chars[temp];
//                         temp++;
//                     }
//                     n -= (j - i - 1);
//                     i++;
//                     j = i - 1;
//                     j++;
//                 } else {
//                     i++;
//                     freq = 0;
//                     continue;
//                 }
//             }
//         }
//         if (freq > 1) {
//             for (char c : Integer.toString(freq).toCharArray()) {
//                 chars[++i] = c;
//             }
//         }
//         return i + 1;
//     }
// }

class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int read = 0;
        int write = 0;

        while (read < n) {
            char current = chars[read];
            int count = 0;

            // Count consecutive occurrences
            while (read < n && chars[read] == current) {
                count++;
                read++;
            }

            // Write the character
            chars[write] = current;
            write++;

            // Write frequency only if > 1
            if (count > 1) {
                for (char digit : Integer.toString(count).toCharArray()) {
                    chars[write] = digit;
                    write++;
                }
            }
        }

        return write;
    }
}