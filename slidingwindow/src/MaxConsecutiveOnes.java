public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {

        int maxOnes = 0, n = nums.length;
        int i = 0, j = 0, count = 0;
        while(i < n && j < n) {
            if(nums[j] == 1) {
                count++;
                j++;
            } else {
                count = j - i;
                maxOnes = Math.max(count, maxOnes);
                count = 0;
                j++;
                i = j;
            }
        }

        maxOnes = Math.max(count, maxOnes);

        return maxOnes;
    }
}
