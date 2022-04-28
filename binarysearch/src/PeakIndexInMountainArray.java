public class PeakIndexInMountainArray {
    // algorithm with O(log n) runtime complexity.
    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length == 1) return 0;

        int low = 0, high = arr.length-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(mid > 0  && mid < arr.length-1) {
                if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                    return mid;
                } else if(arr[mid-1] > arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if(mid == 0) {
                if(arr[mid] > arr[mid+1]) {
                    return mid;
                } else {
                    return mid+1;
                }
            } else if(mid == arr.length-1) {
                if(arr[mid] > arr[mid-1]) {
                    return mid;
                } else {
                    return mid-1;
                }
            }
        }
        return -1;
    }
}
