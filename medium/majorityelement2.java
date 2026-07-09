// 229. Majority Element II
// Medium
// Topics
// premium lock icon
// Companies
// Hint
// Given an integer array of size n, find all elements that appear more than ⌊n / 3⌋ times.

// Example 1:
// Input: nums = [3,2,3]
// Output: [3]
// Example 2:
// Input: nums = [1]
// Output: [1]
// Example 3:
// Input: nums = [1,2]
// Output: [1,2]
// Constraints:
// 1 <= nums.length <= 5 * 104
// -109 <= nums[i] <= 109
// Follow up: Could you solve the problem in linear time and in O(1) space?
import java.util.*;

class Solution {

    public static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        map.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
        for (Integer key : map.keySet()) {
            if (map.get(key) > (nums.length / 3)) {
                list.add(key);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3};

    System.out.print(majorityElement(nums));
    }
}
