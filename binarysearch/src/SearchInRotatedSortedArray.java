public class SearchInRotatedSortedArray {
    // algorithm with O(log n) runtime complexity.
    public int search(int[] nums, int target) {
        int n = nums.length;
        int minIndex = findKRotation(nums, n);
        int left = 0, right = minIndex-1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = minIndex; right = n-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int findKRotation(int[] arr, int n) {
        int left = 0, right = n-1;

        while(left <= right) {
            if(arr[left] <= arr[right]) {
                return left;
            }

            int mid = left + (right - left)/2;
            int prev = (mid + n -1) % n;
            int next = (mid + 1) % n;

            if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                return mid;
            }
            else if(arr[left] <= arr[mid]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
