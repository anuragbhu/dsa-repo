public class FindingPosition {
    // TC = O(logn), AS = O(1)
    static long nthPosition(long n){
        int count = 0;
        while(n != 0) {
            n >>= 1; // or n /= 2
            count++;
        }
        return 1L << count-1;
    }

    // Time complexity : O(n). In worst case, the loop runs floor(n/2) times. The worst case happens when n is of the
    // form 2x – 1. E.g. n = 31
    static long nthPosition1(long n){
        for(long i = n; i >= 1; i--) {
            if((i & (i-1)) == 0)
                return i;
        }
        return 0L;
    }
}
