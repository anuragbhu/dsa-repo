public class Rotation {
    // algorithm with O(log n) runtime complexity.
    // Find minimum index or number of times sorted array is rotated.
    public static int findKRotation(int[] arr, int n) {
        int left = 0, right = n-1;

        // Equal to sign is required as it might be the case when result is at the same index.
        while(left <= right) {
            //when array is already sorted
            if(arr[left] <= arr[right]) {
                return left;
            }

            int mid = left + (right - left)/2;
            int prev = (mid + n -1) % n;
            int next = (mid + 1) % n;

            //mid is less then the prev and the next element
            if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                // If we lies in this condition then
                // Prev will be largest and next will be second smallest.
                return mid;
            }
            else if(arr[left] <= arr[mid]) { // implies all the left elements are smaller than
                // the mid element.
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
