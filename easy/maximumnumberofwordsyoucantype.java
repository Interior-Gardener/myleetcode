// 1935. Maximum Number of Words You Can Type
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.

// Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.

// Example 1:

// Input: text = "hello world", brokenLetters = "ad"
// Output: 1
// Explanation: We cannot type "world" because the 'd' key is broken.
// Example 2:

// Input: text = "leet code", brokenLetters = "lt"
// Output: 1
// Explanation: We cannot type "leet" because the 'l' and 't' keys are broken.
// Example 3:

// Input: text = "leet code", brokenLetters = "e"
// Output: 0
// Explanation: We cannot type either word because the 'e' key is broken.

// Constraints:

// 1 <= text.length <= 104
// 0 <= brokenLetters.length <= 26
// text consists of words separated by a single space without any leading or trailing spaces.
// Each word only consists of lowercase English letters.
// brokenLetters consists of distinct lowercase English letters.

class Solution {
    public int canBeTypedWords(String b, String a) {
        boolean[] broke = new boolean[26];
        for (char c : a.toCharArray()) {
            broke[c - 'a'] = true;
        }

        int res = 0;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) != ' ' && broke[b.charAt(i) - 'a']) {
                res++;
                while (i < b.length() && b.charAt(i) != ' ')
                    i++;
            }
        }
        String[] str = b.split(" ");
        return str.length - res;
    }
}