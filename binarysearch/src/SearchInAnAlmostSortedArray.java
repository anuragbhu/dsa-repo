public class SearchInAnAlmostSortedArray {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid = -1;
        while(left <= right) { // equal to sign when left & right at same index and target value is on it.
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(mid-1 >= left && nums[mid-1] == target)
                return mid-1;
            if(mid+1 <= right && nums[mid+1] == target)
                return mid+1;

            if(nums[mid] < target) {
                left = mid + 2;
            } else {
                right = mid - 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {10, 3, 40, 20, 50, 80, 70};
        int target = 3;

        System.out.println(search(nums, target));
    }
}
