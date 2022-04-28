public class FloorInASortedArray {
    static int findFloor(long[] arr, int n, long x) {
        int left = 0, right = arr.length-1, mid = -1, res = -1; // index return
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(arr[mid] == x) {
                return mid;
            } else if(arr[mid] < x) { // all the elements less than the target can be the candidate. But, we need to
                // select the one which is less than closest or equal to target.
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
