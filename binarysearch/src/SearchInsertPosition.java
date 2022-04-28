public class SearchInsertPosition {
    // algorithm with O(n) runtime complexity.
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(target == nums[i])
                return i;
            else if(nums[i] > target)
                return i;
        }
        return nums.length;
    }

    // algorithm with O(logn) runtime complexity.
    public int searchInsert1(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid = -1;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right+1;
    }
}
