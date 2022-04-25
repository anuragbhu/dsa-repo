public class RemoveDuplicatesFromSortedArray {
    // TC = O(n), SC = O(1)
    public int removeDuplicates(int[] nums) {
        int count = 1;
        if(nums.length == 1) return 1;

        int left = 0, right = 1;

        while(right < nums.length) {
            if(nums[left] == nums[right]) {
                right++;
            } else {
                left++;
                nums[left] = nums[right];
                count++;
                right++;
            }
        }
        return count;
    }
}
