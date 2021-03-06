import java.util.Arrays;

public class KthLargestElementInArray {
    // Time Complexity = O(nlogn)
    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);

        return nums[nums.length - k];
    }
}
