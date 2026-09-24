// 211. Design Add and Search Words Data Structure
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Design a data structure that supports adding new words and finding if a string matches any previously added string.

// Implement the WordDictionary class:

// WordDictionary() Initializes the object.
// void addWord(word) Adds word to the data structure, it can be matched later.
// bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

// Example:

// Input
// ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
// [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
// Output
// [null,null,null,null,false,true,true,true]

// Explanation
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("bad");
// wordDictionary.addWord("dad");
// wordDictionary.addWord("mad");
// wordDictionary.search("pad"); // return False
// wordDictionary.search("bad"); // return True
// wordDictionary.search(".ad"); // return True
// wordDictionary.search("b.."); // return True
 

// Constraints:

// 1 <= word.length <= 25
// word in addWord consists of lowercase English letters.
// word in search consist of '.' or lowercase English letters.
// There will be at most 2 dots in word for search queries.
// At most 104 calls will be made to addWord and search.

import java.util.*;
class WordDictionary {
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

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            if (i == word.length() - 1) {
                curr.children[idx].eow = true;
            }

            curr = curr.children[idx];
        }
    }

    public boolean search(String word) {
        return recursiveSearch(word, root);
    }

    boolean recursiveSearch(String word, TrieNode curr) {
        if (word.equals("")) {
            return true;
        }

        if (word.charAt(0) != '.' && curr.children[word.charAt(0) - 'a'] != null) {
            if (word.length() == 1 && curr.children[word.charAt(0) - 'a'].eow) {
                return true;
            }

            else if (word.length() == 1 && !curr.children[word.charAt(0) - 'a'].eow) {
                return false;
            }
        }

        else if (word.charAt(0) == '.' && word.length() == 1) {
            for(int i = 0 ; i < 26 ;i++) {
                if(curr.children[i] != null && curr.children[i].eow){
                    return true;
                }
            }
            return false;
        }

        char c = word.charAt(0);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    boolean isthere = recursiveSearch(word.substring(1, word.length()), curr.children[i]);
                    if (isthere)
                        return true;
                }
            }
            return false;
        } else {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                return false;
            } else {
                return recursiveSearch(word.substring(1, word.length()), curr.children[idx]);
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */