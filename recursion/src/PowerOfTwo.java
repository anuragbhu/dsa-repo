public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        long x = n;
        return x > 0 && ((x & (x - 1)) == 0);
    }

    public boolean isPowerOfTwo1(int n) {
         if (n < 1) {
             return false;
         }

         while (n % 2 == 0) {
             n /= 2;
         }

         return n == 1;
    }
}
