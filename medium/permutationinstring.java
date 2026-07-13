// 567. Permutation in String
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

// In other words, return true if one of s1's permutations is the substring of s2.

// Example 1:

// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").
// Example 2:

// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false

// Constraints:

// 1 <= s1.length, s2.length <= 104
// s1 and s2 consist of lowercase English letters.
import java.util.*;

class Solution {
    // public static boolean checkInclusion(String s1, String s2) {
    // if(s1.length() == 0) return true;
    // if(s1.length() > s2.length()) return false;
    // StringBuilder str = new StringBuilder(s2);
    // ArrayList<Integer> arr = new ArrayList<>();
    // for( int i = 0 ; i < s1.length() ; i++ ) {
    // for(int j = 0 ; j < str.length() ; j++) {
    // if(s1.charAt(i) == str.charAt(j)) {
    // arr.add(j);
    // str = str.deleteCharAt(j);
    // break;
    // }
    // }
    // }
    // // System.out.println(arr);
    // int max = Integer.MIN_VALUE;
    // int min = Integer.MAX_VALUE;

    // for(int i = 0 ; i < arr.size() ; i++) {
    // max = Math.max(max,arr.get(i));
    // min = Math.min(min,arr.get(i));
    // }

    // if(max-min+1 == s1.length()) return true;
    // else return false;
    // }

    // public static boolean checkInclusion(String s1, String s2) {
    // if (s1.length() > s2.length())
    // return false;
    // return perminstr(s1, s2, "", new boolean[s1.length()]);
    // }

    // public static boolean perminstr(String s1 , String s2 , String res ,
    // boolean[] used ) {
    // // if(ispresent) return true;
    // System.out.println(res + " <result");
    // if(res.length() == s1.length() && s2.contains(res)) {
    // System.out.println("here");
    // // ispresent = true;
    // return true;
    // };

    // for(int i = 0 ; i < s1.length() && res.length() <= s1.length() ; i++) {
    // if(used[i]) continue;
    // res = res + s1.charAt(i);
    // used[i] = true;
    // // if(res.length() > s1.length()) break;
    // // System.out.println("hii");
    // // int next = index+1;
    // if(perminstr(s1, s2, res,used)) return true;
    // perminstr(s1, s2, res,used);
    // // System.out.println(ispresent);
    // // if(ispresent) return true;
    // // index--;
    // res = res.substring(0,res.length() - 1);
    // used[i] = false;
    // }
    // return false;
    // }

    public static boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];
        for(char c : s1.toCharArray()) {
            freq[c-'a']++;
        }
        int n = s1.length();
        for(int i = 0 , j = n-1 ; j < s2.length() ; i++,j++) {
            int[] freq1 = new int[26];
            // int a=i;
            String temp = s2.substring(i,j+1);
            for(char c : temp.toCharArray())
                freq1[c-'a']++;
            for(int k = 0 ; k < 26 ; k++){
                if(freq[k] != freq1[k]) {
                    // System.out.println("here");
                    break;
                }
                if(freq[k] == freq1[k] && k == 25) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // String s1 = "", s2 = "";
        // String s1 = "ab", s2 = "eidboaoo";
        String s1 = "ab", s2 = "eidbaooo";
        // String s1 = "hello", s2 = "ooolleoooleh";
        // String s1 = "intention", s2 = "execution";

        System.out.println(checkInclusion(s1, s2));
    }
}