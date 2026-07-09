// 22. Generate Parentheses
// Medium
// Topics
// premium lock icon
// Companies
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// Example 1:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:
// Input: n = 1
// Output: ["()"]
// Constraints:
// 1 <= n <= 8
import java.util.*;



    // public static List<String> generateParenthesis(int n) {
    //     List<String> result = new ArrayList<>();
    //     List<String> list = new ArrayList<>();
    //     HashSet<String> set = new HashSet<>();
    //     for (int i = 0; i < n; i++) {
    //         list.add("(");
    //     }
    //     for (int i = 0; i < n; i++) {
    //         list.add(")");
    //     }

    //     // System.out.println(list);
    //     if (n == 1) {
    //         String add1 = String.join("", list);
    //         List<String> results = new ArrayList<>();
    //         results.add(add1);
    //         // System.out.println(results);
    //         return results;
    //     }
    //     for (int i = 0; i < list.size() - 2; i++) {
    //         for (int j = i + 1; j < list.size(); j++) {
    //             ArrayList<String> temp = new ArrayList<>(list);
    //             String a = list.get(j);
    //             temp.set(j, temp.get(i));
    //             temp.set(i, a);
    //             // System.out.println(temp);
    //             if (isValid(temp)) {
    //                 // StringBuilder temp1 = new StringBuilder();
    //                 // set.add(temp.toString());
    //                 String add1 = String.join("", temp);
    //                 set.add(add1);
    //             }
    //         }
    //     }
    //     for (String s : set) {
    //         // result.add(s);
    //         StringBuilder temp = new StringBuilder();
    //         for (int i = 0; i < s.length(); i++) {
    //             temp.append(s.charAt(i));
    //         }
    //         // System.out.println(temp + "temp");
    //         result.add(temp.toString());

    //     }
    //     // System.out.println(result);
    //     return result;
    // }

    // public static List<String> generateParenthesis(int n) {
    //     if(n == 1){
    //         List<String> result = new ArrayList<>();
    //         result.add("()");
    //         return result;
    //         }

    //     List<String> result = new ArrayList<>();
    //     StringBuilder parenthesis = new StringBuilder();
    //     HashSet<String> set = new HashSet<>();

    //     for(int i = 0 ; i < n;i++){
    //         parenthesis.append("(");
    //         parenthesis.append(")");
    //     }

    //     getpermutations(parenthesis,0,set);

    //     for(String s:set){
    //         result.add(s);
    //     }
    //     System.out.println(result.size());
        
    //     return result;

    // }

    // public static void getpermutations(StringBuilder parenthesis ,  int index , HashSet<String> set) {
    //     if(index == parenthesis.length()){
    //         if(isValid(parenthesis)){
    //             String temp = parenthesis.toString();
    //             set.add(temp);
    //             return;
    //         }
    //     }
    //     for(int i = index ; i < parenthesis.length() ; i++) {
    //         if(!isValid(parenthesis)) continue;
    //         if(parenthesis.charAt(0) == ')' || parenthesis.charAt(parenthesis.length()-1) == '(') continue;
    //         swap(parenthesis,index,i);
    //         if(isValid(parenthesis))
    //         getpermutations(parenthesis,index+1,set);
    //         swap(parenthesis,index,i);

    //     }
        
    // }


class Solution {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    public static void backtrack(List<String> result, String current,
                          int open, int close, int n) {

        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add '(' if we still have some left
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }

        // Add ')' only if it won't make the string invalid
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }


    public static void swap(StringBuilder str , int i ,int j){
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j,temp);

    }

    public static boolean isValid(StringBuilder str){
        Stack<Character> s = new Stack<>();
        for(int i = str.length()-1 ; i>=0 ; i--){
            if(str.charAt(i) == ')') s.push(')');
            else {
                if(s.isEmpty()) return false;
                s.pop();
            }
        }
        return s.isEmpty();
    }

    // public static boolean isValid(ArrayList<String> list) {
    //     Stack<String> s = new Stack<>();
    //     for (int i = list.size() - 1; i >= 0; i--) {
    //         if (list.get(i).equals(")")) {
    //             s.push(")");
    //         } else {
    //             if (s.isEmpty()) {
    //                 return false;
    //             }
    //             s.pop();
    //         }
    //     }
        
    //     return s.isEmpty();
    // }

    public static void main(String[] args) {
        // int n = 3;
        int n = 6;

        generateParenthesis(n);
    }
}
