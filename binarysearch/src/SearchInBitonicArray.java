import java.util.ArrayList;

public class SearchInBitonicArray {
    // algorithm with O(log n) runtime complexity.
    public int solve(ArrayList<Integer> A, int B) {
        int index = peakIndexInMountainArray(A);

        // Ascending
        int left = 0, right = index - 1;
        int mid = -1;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(A.get(mid) == B) {
                return mid;
            } else if(A.get(mid) < B) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Descending
        left = index; right = A.size()-1;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(A.get(mid) == B) {
                return mid;
            } else if(A.get(mid) < B) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int peakIndexInMountainArray(ArrayList<Integer> A) {
        if(A.size() == 1) return 0;

        int low = 0, high = A.size()-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(mid > 0  && mid < A.size()-1) {
                if(A.get(mid) > A.get(mid-1) && A.get(mid) > A.get(mid+1)) {
                    return mid;
                } else if(A.get(mid-1) > A.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if(mid == 0) {
                if(A.get(mid) > A.get(mid+1)) {
                    return mid;
                } else {
                    return mid+1;
                }
            } else if(mid == A.size()-1) {
                if(A.get(mid) > A.get(mid-1)) {
                    return mid;
                } else {
                    return mid-1;
                }
            }
        }
        return -1;
    }
}
