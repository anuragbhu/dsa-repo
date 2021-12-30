import java.util.ArrayList;

public class PrimeNumbers {
    public ArrayList<Integer> sieve(int A) {

        ArrayList<Integer> res = new ArrayList<Integer>();

        if(A <= 1)
            return res;

        boolean[] prime = new boolean[A+1];

        for(int i = 0; i <= A; i++) {
            prime[i] = true;
        }

        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i <= Math.sqrt(A); i++) {

            if(prime[i]) {
                for(int j = 2; (i * j) <= A; j++)
                    prime[i*j] = false;
            }
        }

        for(int i = 0; i <= A; i++) {
            if(prime[i]) res.add(i);
        }

        return res;
    }
}
