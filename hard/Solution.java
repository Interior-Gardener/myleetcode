// Problem
// Submissions
// Leaderboard
// Discussions
// Editorial
// In an array, , the elements at indices  and  (where ) form an inversion if . In other words, inverted elements  and  are considered to be "out of order". To correct an inversion, we can swap adjacent elements.

// Example


// To sort the array, we must perform the following two swaps to correct the inversions:

// The sort has two inversions:  and .
// Given an array , return the number of inversions to sort the array.

// Function Description

// Complete the function countInversions in the editor below.

// countInversions has the following parameter(s):

// int arr[n]: an array of integers to sort
// Returns

// int: the number of inversions
// Input Format

// The first line contains an integer, , the number of datasets.

// Each of the next  pairs of lines is as follows:

// The first line contains an integer, , the number of elements in .
// The second line contains  space-separated integers, .
// Constraints

// Sample Input

// STDIN       Function
// -----       --------
// 2           d = 2
// 5           arr[] size n = 5 for the first dataset
// 1 1 1 2 2   arr = [1, 1, 1, 2, 2]
// 5           arr[] size n = 5 for the second dataset     
// 2 1 3 1 2   arr = [2, 1, 3, 1, 2]
// Sample Output

// 0  
// 4   
// Explanation

// We sort the following  datasets:

//  is already sorted, so there are no inversions for us to correct.
// We performed a total of  swaps to correct inversions.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countInversions' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long countInversions(List<Integer> arr) {
    // Write your code here
        Result sol = new Result();
        long res = 0;
        int high = arr.size()-1;
        while(high > 0 && !sol.sorted(arr)) {
            int low = sol.findmax(arr,high);
            res+= (high-low);
            sol.shift(arr , low , high);
            high--;
        }
        return res;
    }
    
    public void shift (List<Integer> list,int low,int high) {
        int temp = list.get(low);
        list.remove(low);
        list.add(high, temp);
        
    }
    
    public int findmax(List<Integer> list,int high) {
        int maxidx = -1;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i <= high ; i++) {
            if(list.get(i) >= max) {
                max = list.get(i);
                maxidx = i;
            }
        }
        return maxidx;
    }
    
    public boolean sorted(List<Integer> list) {
        for(int i = 0 ; i < list.size() - 1 ; i++){
            if(list.get(i) > list.get(i+1)) return false;
        }
        return true;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                long result = Result.countInversions(arr);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
