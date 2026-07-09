// 852. Peak Index in a Mountain Array
// Medium
// Topics
// premium lock icon
// Companies
// You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.

// Return the index of the peak element.

// Your task is to solve it in O(log(n)) time complexity.

 

// Example 1:

// Input: arr = [0,1,0]

// Output: 1

// Example 2:

// Input: arr = [0,2,1,0]

// Output: 1

// Example 3:

// Input: arr = [0,10,5,2]

// Output: 1

 

// Constraints:

// 3 <= arr.length <= 105
// 0 <= arr[i] <= 106
// arr is guaranteed to be a mountain array.

class Solution {
    public static int BS(int[] arr ,int n,int start, int i , int mid , int j){
        if((mid-1) < 0 || (mid -1) < start){
            if(arr[mid] > arr[mid+1]) return mid;
            else return j;
        }

        if((mid+1) >= arr.length || (mid+1) > n) {
            if(arr[mid] > arr[mid-1]) return mid;
            else return mid-1;
        }
        while(start <= mid){
            if(arr[mid] >= arr[i] && arr[mid] >= arr[j]) return mid;
            else if (arr[i] > arr[mid]) {
                int temp = mid;
                mid = (mid+start)/2;
                i=mid-1;
                j=mid+1;
                return BS(arr,temp,start, i, mid, j);
            }
            else{
                start = mid;
                mid = start + (n-start)/2;
                i = mid-1;
                j = mid+1;
                return BS(arr,n,start, i, mid, j);

            }
        }
        return 1; //[40,48,61,75,100,99,98,39,30,10]
    }
    public int peakIndexInMountainArray(int[] arr) {
        
        int mid = arr.length/2;
        int i = mid-1;
        int j = mid+1;
        return BS(arr,arr.length,0,i,mid,j);
        
    }
}