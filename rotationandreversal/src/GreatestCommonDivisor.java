public class GreatestCommonDivisor {
    public int gcd(int A, int B) {
        int min = Math.min(A, B);

        for(int i = min; i > 0 ; i--) {
            if((A % i == 0) && (B % i == 0)) {
                return i;
            }
        }

        return (A == 0) ? B : A;
    }

    public int gcd1(int A, int B) {
        if(A == 0)
            return B;

        return gcd1(B % A, A);
    }
}
