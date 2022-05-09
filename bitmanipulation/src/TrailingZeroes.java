public class TrailingZeroes {
    // TC = O(logn), AS = O(11)
    public int trailingZeroes(int n) {
        int count = 0;
        while(n/5 > 0) {
            count += n/5;
            n /= 5;
        }
        return count;
    }
}
