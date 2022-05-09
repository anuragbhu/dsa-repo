public class PowerOfTwo {
    // TC = O(1), SC = O(1)
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }

    // TC = O(logn), SC = O(1)
    public boolean isPowerOfTwo1(int n) {
        if(n <= 0) return false;
        while(n > 1) {
            if(n % 2 != 0)
                return false;
            n /= 2;
        }
        return n == 1;
    }
}
