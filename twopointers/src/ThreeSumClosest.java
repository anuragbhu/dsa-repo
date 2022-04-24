import java.util.Arrays;

public class ThreeSumClosest {
    // TC = O(n^3), SC = O(1)
    public int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE, closest = Integer.MAX_VALUE;

        for(int i = 0; i <= nums.length-3; i++) {
            for(int j = i + 1; j <= nums.length-2; j++) {
                for(int k = j + 1; k <= nums.length-1; k++) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k];
                    int diff = (int) Math.abs(sum - target);
                    if(diff < closest) {
                        closest = diff;
                        ans = (int) sum;
                    }
                }
            }
        }
        return ans;
    }

    // TC = O(n^2), SC = O(1)
    public int threeSumClosest1(int[] nums, int target) {
        int ans = Integer.MAX_VALUE, closest = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length-3; i++) {
            int j = i+1, k = nums.length-1; // j = low, k = high
            while(j < k) {
                long sum = (long) nums[i] + (long) nums[j] + (long) nums[k];
                if(sum == target) {
                    return target;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
                int diff = (int) Math.abs(sum - target);
                if(diff < closest) {
                    closest = diff;
                    ans = (int) sum;
                }
            }
        }
        return ans;
    }
}
