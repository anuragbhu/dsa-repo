import java.util.HashSet;

public class SubarrayWith0Sum {
    // TC = O(n^2), As = O(1)
    static boolean findsum(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += arr[j];
                if(sum == 0)
                    return true;
            }
        }
        return false;
    }

    // TC = O(n), As = O(n)
    static boolean findsum1(int[] arr, int n) {
        HashSet<Integer> hset = new HashSet<>();
        int prefixSum = 0;
        hset.add(0); // 10 -10
        for(int i = 0; i < n; i++) {
            prefixSum += arr[i];

            if(hset.contains(prefixSum))
                return true;
            else
                hset.add(prefixSum);
        }
        return false;
    }
}
