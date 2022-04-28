public class NumberOfOccurrence {
    // algorithm with O(n) runtime complexity.
    int count1(int[] arr, int n, int x) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(x == arr[i])
                count++;
        }
        return count;
    }

    // algorithm with O(log n) runtime complexity.
    int count(int[] arr, int n, int x) {
        int start = -1, end = -1;

        // Search for the left one
        int left = 0, right = arr.length-1, mid = -1;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(arr[mid] == x) {
                start = mid;
                right = mid - 1;
            } else if(arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Search for the right one
        left = 0; right = arr.length-1;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(arr[mid] == x) {
                end = mid;
                left = mid + 1;
            } else if(arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if(start == -1 || end == -1) return 0;

        return (end - start + 1);
    }
}
