public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {

        int minLength = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {

            int sum = 0;
            int j = 0;

            for(j = i; j < nums.length; j++) {
                sum += nums[j];

                if(sum >= target) {
                    int length = j - i + 1;
                    minLength = Math.min(length, minLength);
                    break;
                }
            }
        }

        if(minLength == Integer.MAX_VALUE)
            return 0;

        return minLength;

    }
}
