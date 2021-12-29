import java.util.ArrayList;

public class SieveOfEratosthenes {
    static ArrayList<Integer> sieveOfEratosthenes(int N){

        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int i = 2; i <= N; i++) {
            int count = 0;
            for(int j = 2; j <= N; j++) {
                if(i % j == 0) {
                    count++;
                }
            }
            if(count == 1) res.add(i);
        }

        return res;
    }
}
