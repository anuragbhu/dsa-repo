import java.util.ArrayList;

public class SieveOfEratosthenes {
    static ArrayList<Integer> sieveOfEratosthenes(int N){

        ArrayList<Integer> res = new ArrayList<Integer>();

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

    static ArrayList<Integer> sieveOfEratosthenes1(int N){

        ArrayList<Integer> res = new ArrayList<Integer>();

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

    static ArrayList<Integer> sieveOfEratosthenes2(int N){

        ArrayList<Integer> res = new ArrayList<Integer>();

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

    static ArrayList<Integer> sieveOfEratosthenes3(int N){

        ArrayList<Integer> res = new ArrayList<Integer>();
        boolean[] prime = new boolean[N+1];

        for(int i = 0; i <= N; i++) {
            prime[i] = true;
        }

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= Math.sqrt(N); i++) {

            if(prime[i]) {
                for(int j = 2; (i * j) <= N; j++)
                    prime[i*j] = false;
            }
        }

        for(int i = 0; i <= N; i++) {
            if(prime[i]) res.add(i);
        }

        return res;
    }
}
