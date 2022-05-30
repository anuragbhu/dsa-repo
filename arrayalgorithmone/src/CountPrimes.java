public class CountPrimes {
    // TC = O(nloglogn), AS = O(n)
    public int countPrimes(int n) {
        int count = 0;
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

        for(int i = 2; i < n; i++) { // Strictly less than n
            if(primes[i])
                count++;
        }
        return count;
    }
}
