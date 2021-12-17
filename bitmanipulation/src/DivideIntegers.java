public class DivideIntegers {
    public int divide1(int A, int B) {
        long test = (long)A/B;
        if (test > Integer.MAX_VALUE || test < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        return A/B;
    }

    public int divide2(int A, int B) { // O(Dividend)

        if (B == 0) return Integer.MAX_VALUE;
        if (A == Integer.MIN_VALUE && B == -1) return Integer.MAX_VALUE;
        if (A == B) return 1;
        if (B == 1) return A;
        if (B == -1) return -A;
        if (B == 2) return (A >> 1);
        int count = 0;

        if(A < 0 && B < 0) {
            while(A < 0) {
                A -= B;
                count++;
            }
            return count-1;
        } else {
            while(A > B) {
                A -= B;
                count++;
            }
        }
        return count;
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == divisor) return 1;
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;
        if (divisor == 2) return (dividend >> 1);

        return (int) res(dividend, divisor);
    }

    private long res(long dividend, long divisor) {
        boolean sign = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = true;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int result = (int) Math.floor(Math.exp(Math.log(dividend) - Math.log(divisor)));
        return sign ? -result : result;
    }

}
