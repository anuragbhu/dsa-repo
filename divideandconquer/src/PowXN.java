public class PowXN {
    // TC = O(logn) SC = O(1)
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double ans = 1.0;

        long nn = n; // Copy the value of n. As in algo the val of n is destroyed.
        if(nn < 0) nn = -1 * nn;

        while(nn > 0) {
            if(nn % 2 == 1) { // Odd power
                ans = ans * x;
                nn = nn - 1;
            } else { // Even power
                x = x * x;
                nn = nn / 2;
            }
        }

        if(n < 0) ans = 1.0 / ans; // Negative Power
        return ans;
    }

    // TC = O(n) SC = O(1)
    public double myPow1(double x, int n) {
        if(n == 0) return 1.0;
        double ans = 1.0;

        if(n > 0) {
            for(int i = 0; i < n; i++)
                ans *= x;
        } else {
            n *= -1;
            for(int i = 0; i < n; i++)
                ans *= x;
            ans = 1/ans;
        }
        return ans;
    }

    // TC = O(1) SC = O(1)
    public double myPow2(double x, int n) {
        return Math.pow(x, n);
    }
}
