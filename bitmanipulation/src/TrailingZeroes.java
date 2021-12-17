public class TrailingZeroes {
    public int solve(int A) {
        int position = 0;
        int count = 0;
        while(true) {
            int mask = 1 << position;
            int result = A & mask;

            if (result != 0) {
                break;
            }
            count++;
            position++;

        }

        return count;
    }
}
