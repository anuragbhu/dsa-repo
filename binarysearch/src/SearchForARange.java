public class SearchForARange {

    // algorithm with O(n) runtime complexity.
    public int[] searchRange1(int[] nums, int target) {
        int[] res = new int[2];
        boolean isStart = true;
        res[0] = -1; res[1] = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                if(isStart) {
                    res[0] = i;
                    res[1] = i;
                    isStart = false;
                } else {
                    res[1] = i;
                }
            }
        }
        return res;
    }

    // algorithm with O(log n) runtime complexity.
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1; res[1] = -1;

        // Search for the left one
        int left = 0, right = nums.length-1, mid = -1;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                res[0] = mid;
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Search for the right one
        left = 0; right = nums.length-1;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                res[1] = mid;
                left = mid + 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}
