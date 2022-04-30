public class FirstBadVersion {

    boolean isBadVersion(int version) {
        /*
        ------- Some Implementation -------
         */
        return true;
    }

    public int firstBadVersion(int n) {
        int first = 1;

        int low = 0, high = n;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(isBadVersion(mid)) {
                first = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return first;
    }
}
