public class FindMinimumInRotatedSortedArray {
    // algorithm with O(log n) runtime complexity.
    public int findMin(int[] nums) {
        int left = 0, n = nums.length, right = n-1;

        // Equal to sign is required as it might be the case when result is at the same index.
        while(left <= right) {
            //when array is already sorted
            if(nums[left] <= nums[right]) {
                return nums[left];
            }

            int mid = left + (right - left)/2;
            int prev = (mid + n -1) % n;
            int next = (mid + 1) % n;

            //mid is less then the prev and the next element
            if(nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                // If we lies in this condition then
                // Prev will be largest and next will be second smallest.
                return nums[mid];
            }
            else if(nums[left] <= nums[mid]) {
                // implies all the left elements are smaller than the mid element.
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
