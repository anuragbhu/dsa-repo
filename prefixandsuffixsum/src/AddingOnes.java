public class AddingOnes {
    public static void update(int[] a, int n, int[] updates, int k) {
        // TC = O(kn), AS = O(1)
        for(int j = 0; j < k; j++) {
            for(int i = 0; i < n; i++) {
                if(i >= updates[j]-1)
                    a[i] += 1;
            }
        }
    }

    public static void update1(int[] a, int n, int[] updates, int k) {
        // TC = O(max(n,k)), AS = O(1)
        for(int i = 0; i < k; i++)
            a[updates[i]-1]++;
        for(int i = 1; i < n; i++)
            a[i] += a[i-1];
    }
}
