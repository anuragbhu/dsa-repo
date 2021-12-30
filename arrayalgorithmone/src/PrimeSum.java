import java.util.ArrayList;

public class PrimeSum {
    public ArrayList<Integer> primesum(int A) {

        ArrayList<Integer> res = new ArrayList<Integer>();

        if(A <= 2) return res;


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

        for(int i = 0; i <= A/2; i++) {
            if(prime[i]) {
                int second = A - i;
                if(prime[second]){
                    res.add(i);
                    res.add(second);
                    break;
                }
            }
        }

        return res;
    }

    private boolean isPrime(int a){
        for(int i=2;i<=(int)Math.sqrt(a);i++){
            if(a%i==0)
                return false;
        }
        return true;
    }
    public ArrayList<Integer> primesum1(int a) {
        ArrayList<Integer> x= new ArrayList<Integer>();
        for(int i=2;i<a;i++){
            if(isPrime(i)&&isPrime(a-i)){
                x.add(i);
                x.add(a-i);
                break;
            }
        }
        return x;
    }
}
