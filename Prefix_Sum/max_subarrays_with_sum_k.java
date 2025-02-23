package Prefix_Sum;
import java.util.*;
public class max_subarrays_with_sum_k {
    public static int countSubarraysWithSumK(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize with sum 0 to handle cases where subarray starts from index 0

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int rem = sum - k;
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
// Iteration 1 (i = 0):
// sum = 1
// rem = 1 - 0 = 1
// map.containsKey(1) → false
// map.put(1, map.getOrDefault(1, 0) + 1) → map.put(1, 1)
// map is now {0: 1, 1: 1}
// Iteration 2 (i = 1):
//  sum = 0
// rem = 0 - 0 = 0
// map.containsKey(0) → true
// count += map.get(0) → count += 1 → count = 1
// map.put(0, map.getOrDefault(0, 0) + 1) → map.put(0, 2)
// map is now {0: 2, 1: 1}
// Iteration 3 (i = 2):
// sum = 0
// rem = 0 - 0 = 0
// map.containsKey(0) → true
// count += map.get(0) → count += 2 → count = 3
// map.put(0, map.getOrDefault(0, 0) + 1) → map.put(0, 3)
// map is now {0: 3, 1: 1}
    public static void main(String[] args) {
        int[] nums = {1, -1, 0};
        int k = 0;
        System.out.println(countSubarraysWithSumK(nums, k)); // Output: 2
    }
}