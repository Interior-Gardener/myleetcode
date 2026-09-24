// 139. Word Break
// Medium
// Topics
// premium lock icon
// Companies
// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

// Example 1:

// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".
// Example 2:

// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
// Note that you are allowed to reuse a dictionary word.
// Example 3:

// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false
 

// Constraints:

// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.

import java.util.*;
class Solution {
    TrieNode root = new TrieNode();
    HashMap<String, Boolean> dp = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        for (String str : wordDict) {
            insert(str);
        }

        return helper(s, root);
    }

    boolean helper(String s, TrieNode root) {
        if (s.equals("")) {
            return true;
        }

        if (dp.containsKey(s)) {
            return dp.get(s);
        }

        for (int i = 0; i < s.length(); i++) {
            if (search(s.substring(0, i + 1))) {
                // if(search(s.substring(i+1 , s.length()))) {
                //     return true;
                // }
                // if (!dp.getOrDefault(s.substring(i + 1, s.length()), true)) {
                //     continue;
                // }

                boolean next = helper(s.substring(i + 1, s.length()), root);

                if (next) {
                    dp.put(s, true);
                    return true;
                } else {
                    continue;
                }
            }
        }
        dp.put(s, false);
        return false;
    }

    class TrieNode {
        TrieNode[] children;
        boolean eow;

        public TrieNode() {
            children = new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    void insert(String s) {
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            if (i == s.length() - 1) {
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }

    boolean search(String key) {
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                // dp.put(key, false);
                return false;
            }

            if (i == key.length() - 1 && curr.children[idx].eow == false) {
                // dp.put(key, false);
                return false;
            }
            curr = curr.children[idx];
        }
        // dp.put(key, true);
        return true;
    }
}