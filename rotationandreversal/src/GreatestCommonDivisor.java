public class GreatestCommonDivisor {
    public int gcd(int A, int B) {

        if(A == 0)
            return B;

        if(B == 0)
            return A;

        int gcd = 1;

        for(int i = 1; i <= A && i <= B; i++) {
            if((A % i == 0) && (B % i == 0)) {
                gcd = Math.max(i, gcd);
            }
        }

        return gcd;
    }

    public int gcd1(int A, int B) {
        if(A == 0)
            return B;

        return gcd1(B % A, A);
    }
}
