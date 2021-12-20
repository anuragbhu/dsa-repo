public class FindingPosition {
    public static long nthPosition(long n){

        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        n |= n >> 32;

        return n ^ (n >> 1);

    }
}
