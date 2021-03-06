import java.util.ArrayList;

public class PrimeSum {
    // TC = O(nloglogn), AS = O(n)
    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = A;
        boolean[] primes = new boolean[n+1]; // Why? N is inclusive

        for(int i = 2; i < n+1; i++) { // Ignoring 0 and 1? As 2 is the smallest prime.
            primes[i] = true; // Assuming others are true
        }

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(primes[i]) {
                for(int j = 2; (i * j) <= n; j++) { // False for multiple of i
                    primes[i*j] = false;
                }
            }
        }

        for(int i = 2; i < n+1; i++) {
            boolean p = primes[i];
            boolean q = primes[A-i];

            if(p && q) {
                res.add(i);
                res.add(A-i);
                return res;
            }
        }
        return res;
    }
}
