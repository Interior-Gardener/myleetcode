// 1233. Remove Sub-Folders from the Filesystem
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given a list of folders folder, return the folders after removing all sub-folders in those folders. You may return the answer in any order.

// If a folder[i] is located within another folder[j], it is called a sub-folder of it. A sub-folder of folder[j] must start with folder[j], followed by a "/". For example, "/a/b" is a sub-folder of "/a", but "/b" is not a sub-folder of "/a/b/c".

// The format of a path is one or more concatenated strings of the form: '/' followed by one or more lowercase English letters.

// For example, "/leetcode" and "/leetcode/problems" are valid paths while an empty string and "/" are not.

// Example 1:

// Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
// Output: ["/a","/c/d","/c/f"]
// Explanation: Folders "/a/b" is a subfolder of "/a" and "/c/d/e" is inside of folder "/c/d" in our filesystem.
// Example 2:

// Input: folder = ["/a","/a/b/c","/a/b/d"]
// Output: ["/a"]
// Explanation: Folders "/a/b/c" and "/a/b/d" will be removed because they are subfolders of "/a".
// Example 3:

// Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
// Output: ["/a/b/c","/a/b/ca","/a/b/d"]

// Constraints:

// 1 <= folder.length <= 4 * 104
// 2 <= folder[i].length <= 100
// folder[i] contains only lowercase letters and '/'.
// folder[i] always starts with the character '/'.
// Each folder name is unique.

import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean eow;

        public TrieNode() {
            children = new TrieNode[27];
            for (int i = 0; i < 27; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    TrieNode root = new TrieNode();
    List<String> res = new ArrayList<>();

    void add(String s) {
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (s.charAt(i) == '/')
                idx = 26;

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            if (i == s.length() - 1) {
                curr.children[idx].eow = true;
            }

            curr = curr.children[idx];
        }
    }

    void search(TrieNode root, List<String> res, StringBuilder temp) {
        if (root.eow == true) {
            res.add(new StringBuilder(temp).toString());
            boolean yes = false;
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    yes = true;
                    break;
                }
            }
            if (!yes) {
                return;
            }
            // return;
        }
        TrieNode curr = root;

        for (int i = 0; i < 27; i++) {
            if (curr.children[i] != null) {
                if (i == 26) {
                    temp.append('/');
                } else {
                    temp.append((char) (i + 'a'));
                }
                // System.out.println("here" + temp);
                search(curr.children[i], res, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        for (String i : folder) {
            add(i);
        }
        // System.out.println(normalsearch("/c/d"));
        search(root, res, new StringBuilder());
        return res;
    }

    boolean normalsearch(String key) {
        TrieNode curr = root;

        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (key.charAt(i) == '/')
                idx = 26;

            if (curr.children[idx] == null) {
                return false;
            }

            if (i == key.length() - 1 && curr.children[idx].eow == false) {
                return false;
            }

            curr = curr.children[idx];
        }

        return true;
    }
}