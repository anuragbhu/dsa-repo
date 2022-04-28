public class ReverseBinarySearch {
    // Descending sorted Array
    // algorithm with O(log n) runtime complexity.
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid = -1;
        while(left <= right) { // equal to sign when left & right at same index and target value is on it.
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
