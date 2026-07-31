// 912. Sort an Array
// Medium
// Topics
// premium lock icon
// Companies
// Given an array of integers arr, sort the array in ascending order and return it.

// You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

// Example 1:

// Input: arr = [5,2,3,1]
// Output: [1,2,3,5]
// Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
// Example 2:

// Input: arr = [5,1,1,2,0,0]
// Output: [0,0,1,1,2,5]
// Explanation: Note that the values of arr are not necessarily unique.

// Constraints:

// 1 <= arr.length <= 5 * 104
// -5 * 104 <= arr[i] <= 5 * 104

import java.util.ArrayList;

class Solution {
    public int[] sortArray(int[] arr) {
        mergesort(arr, 0, arr.length - 1);
        return arr;
    }

    public void mergesort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergesort(arr,start,mid);
            mergesort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }
    public void merge(int[] arr , int start , int mid , int end) {
        ArrayList<Integer> temp = new ArrayList<>();
        int i = start;
        int j = mid+1;
        while(i <= mid && j <= end) {
            if(arr[i] < arr[j]) {
                temp.add(arr[i]);
                i++;
            }
            else{
                temp.add(arr[j]);
                j++;
            }
        }

        while(i <= mid) {
            temp.add(arr[i]);
            i++;
        }

        while( j <= end) {
            temp.add(arr[j]);
            j++;
        }

        for(int index = 0 ; index < temp.size() ;index++) {
            arr[index + start] = temp.get(index);
        }
    }
}