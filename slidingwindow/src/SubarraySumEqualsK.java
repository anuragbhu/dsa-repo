import java.util.HashMap;

public class SubarraySumEqualsK {
    // TC = O(n^2), AS = O(1)
    public int subarraySum(int[] nums, int k) {
        int maxCount = 0, n = nums.length;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                if(sum == k)
                    maxCount++;
            }
        }
        return maxCount;
    }
    // TC = O(n^2), AS = O(1)
    public int subarraySum1(int[] nums, int k) {
        int count = 0, N = nums.length;
        for(int i = 0; i < N; i++) {
            int sum = 0, j = i;
            while(j < N) {
                sum += nums[j];
                if(sum == k) {
                    count++;
                }
                j++;
            }
        }
        return count;
    }

    // TC = O(n), AS = O(n)
    public int subarraySum2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // <PrefixSum, Count>
        int count = 0, sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == k)
                count++;
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
