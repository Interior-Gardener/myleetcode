
import java.util.*;

class Solution {

    public static List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                list.add(i - 1, "FizzBuzz");
            } else if (i % 5 == 0) {
                list.add(i - 1, "Buzz");
            } else if (i % 3 == 0) {
                list.add(i - 1, "Fizz");
            } else {
                list.add(i - 1, Integer.toString(i));
            }
        }

        return list;
    }

    public static void printList(List<String> list) {
        for (String num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 15;

        printList(fizzBuzz(n));
    }
}
