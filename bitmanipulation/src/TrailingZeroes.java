public class TrailingZeroes {
    // TC = O(logn), AS = O(11)
    public static int trailingZeroes(int n) {
        int count = 0;
        while(n/5 > 0) {
            count += n/5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(24));
    }
}
