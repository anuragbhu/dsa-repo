public class SubarraySumEqualsK {
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
}
