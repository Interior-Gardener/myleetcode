// 17. Letter Combinations of a Phone Number
// Medium
// Topics
// premium lock icon
// Companies
// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = "2"
// Output: ["a","b","c"]
 

// Constraints:

// 1 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].
import java.util.*;
class Solution {
    public static List<String> letterCombinations(String digits) {
        // ArrayList<String> data = new ArrayList<>();
        // data.add("abc");
        // data.add("def");
        // data.add("ghi");
        // data.add("jkl");
        // data.add("mno");
        // data.add("pqrs");
        // data.add("tuv");
        // data.add("xyz");

        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> res = new ArrayList<>();

        backtrack(map , res , new StringBuilder(), digits, 0);
        System.out.println(res);
        return res;
    }

    public static void backtrack(HashMap<Character,String> map, List<String> res, StringBuilder str , String digits, int count ){
        if(str.length() == digits.length()) {
            String was = new String(str);
            res.add(was);
            // count= count -5;
            return;
        }
        String temp = map.get(digits.charAt(count));
        for(int i = 0 ; i < temp.length() ; i++){
            str.append(temp.charAt(i));
            count++;
            backtrack(map, res , str , digits, count);
            count--;
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";

        letterCombinations(digits);
    }
}