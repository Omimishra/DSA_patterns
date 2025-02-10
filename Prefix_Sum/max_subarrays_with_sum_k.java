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

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(countSubarraysWithSumK(nums, k)); // Output: 2
    }
}