public class ReverseBits {
    // TC = O(1), SC = O(1)
    public int reverseBits(int n) {
        System.out.println(n);
        int res = 0;
        for(int i = 0; i < 32; i++){
            res = res << 1;
            int lastBit = n & 1;
            res = res | lastBit;
            n = n >> 1;
        }
        return res;
    }
}
