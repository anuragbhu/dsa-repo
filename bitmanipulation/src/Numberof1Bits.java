public class Numberof1Bits {
    // TC = O(1), SC = O(1)
    // Brian Kernighan's Algorithm
    public int hammingWeight(int n) {
        System.out.println(n);
        int count = 0;
        while(n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
