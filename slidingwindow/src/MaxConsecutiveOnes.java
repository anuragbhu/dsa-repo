public class MaxConsecutiveOnes {
    // TC = O(n), AS = O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max;
    }

    // TC = O(n^2), AS = O(1)
    public int findMaxConsecutiveOnes1(int[] nums) {
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] == 0)
                    break;
                count++;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
