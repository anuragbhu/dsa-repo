public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        // TC = O(logn), SC = O(1)
        if(n <= 0) return false;
        while(n > 1) {
            if(n % 3 != 0)
                return false;
            n /= 3;
        }
        return n == 1;
    }
}
