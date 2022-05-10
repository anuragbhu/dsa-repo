public class SmallestFactorialNumber {
    // TC = O(log5n * log2n), AS = O(1)
    public boolean trailingZeroes(int mid, int n) {
        int count = 0;
        while(mid/5 > 0) {
            count += mid/5;
            mid /= 5;
        }
        return count >= n;
    }

    int findNum(int n) {
        int low = 0, high = 5*n;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(trailingZeroes(mid, n)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}