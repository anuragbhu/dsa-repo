public class FindPeakElement {
    // algorithm with O(n) runtime complexity.
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;

        int i = 0, n = nums.length;
        while((i+1) < n && nums[i] < nums[i+1]) {
            i++;
        }
        return i;
    }

    // algorithm with O(log n) runtime complexity.
    public int findPeakElement1(int[] nums) {
        if(nums.length == 1) return 0;

        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(mid > 0  && mid < nums.length-1) {
                if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                    return mid;
                } else if(nums[mid-1] > nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if(mid == 0) {
                if(nums[mid] > nums[mid+1]) {
                    return mid;
                } else {
                    return mid+1;
                }
            } else if(mid == nums.length-1) {
                if(nums[mid] > nums[mid-1]) {
                    return mid;
                } else {
                    return mid-1;
                }
            }
        }
        return -1;
    }
}
