import java.util.ArrayList;

public class SieveOfEratosthenes {
    // TC = O(n*n), AS = O(1)
    static ArrayList<Integer> sieveOfEratosthenes(int N){
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;
            for(int j = 2; j < i; j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) res.add(i);
        }
        return res;
    }

    // TC = O(n*n/2), AS = O(1)
    static ArrayList<Integer> sieveOfEratosthenes1(int N){
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;
            for(int j = 2; j <= i/2; j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) res.add(i);
        }
        return res;
    }

    // TC = O(n*sqrt(n)), AS = O(1)
    static ArrayList<Integer> sieveOfEratosthenes2(int N){
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) res.add(i);
        }
        return res;
    }

    // TC = O(nloglogn), AS = O(n)
    static ArrayList<Integer> sieveOfEratosthenes3(int N){
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
