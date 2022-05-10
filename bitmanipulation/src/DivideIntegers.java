public class DivideIntegers {
    // Time complexity : O(a/b), Auxiliary space : O(1)
    public static long divide(long a, long b) {
        long sign;

        // Calculate sign of divisor i.e.,
        // sign will be negative only if
        // either one of them is negative
        // otherwise it will be positive
        if(a < 0 && b > 0)
            sign = -1;
        else if(a > 0 && b < 0)
            sign = -1;
        else
            sign = 1;

        // remove sign of operands
        // Update both divisor and
        // dividend positive
        a = Math.abs(a);
        b = Math.abs(b);

        // Initialize the quotient
        long quotient = 0;

        while (a >= b)
        {
            a -= b;
            ++quotient;
        }

        //if the sign value computed earlier is -1 then negate the value of quotient
        if(sign==-1)
            quotient=-quotient;
        return quotient;
    }
}
