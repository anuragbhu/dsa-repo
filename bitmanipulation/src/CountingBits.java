public class CountingBits {
    // TC = O(nlogn), AS = O(1)
    public int[] countBits(int n) {
        int[] count = new int[n+1];

        for(int i = 0; i <= n; i++) {
            count[i] = setCount(i);
        }
        return count;
    }

    public static int setCount(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }


    // TC = O(n), AS = O(1)
    public int[] countBits1(int n) {
        int[] count = new int[n+1];

        for(int i = 0; i <= n; i++) {
            if(i % 2 == 0)
                count[i] = count[i/2];
            else
                count[i] = count[i/2] + 1;
        }
        return count;
    }
}
