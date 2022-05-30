import java.util.ArrayList;

public class PrimeNumbers {
    // TC = O(nloglogn), AS = O(n)
    public ArrayList<Integer> sieve(int A) {
        int N = A;
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] primes = new boolean[N+1]; // Why? N is inclusive

        for(int i = 2; i < N+1; i++) { // Ignoring 0 and 1? As 2 is the smallest prime.
            primes[i] = true; // Assuming others are true
        }

        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(primes[i]) {
                for(int j = 2; (i * j) <= N; j++) { // False for multiple of i
                    primes[i*j] = false;
                }
            }
        }

        for(int i = 2; i < N+1; i++) {
            if(primes[i])
                res.add(i);
        }
        return res;
    }
}
