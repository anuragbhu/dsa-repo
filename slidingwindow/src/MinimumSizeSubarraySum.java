public class MinimumSizeSubarraySum {
    // TC = O(n^2), AS = O(1)
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, minLen = Integer.MAX_VALUE, sum = 0;
        for(int i = 0; i < n; i++) {
            sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                if(sum >= target) {
                    minLen = Math.min((j - i + 1), minLen);
                    break;
                }
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    // TC = O(n), AS = O(1)
    public int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length, i = 0, j = 0, sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (j < n) {
            sum += nums[j];
            if (sum < target) {
                j++;
            } else {
                while (sum >= target) {
                    minLen = Math.min(minLen, j-i+1);
                    sum -= nums[i++];
                }
                j++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
