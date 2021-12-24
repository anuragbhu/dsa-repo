import java.util.List;

public class RotatedArray {
    public int findMin(final List<Integer> a) {

        int min = Integer.MAX_VALUE;

        for(Integer temp : a) {
            min = Math.min(temp, min);
        }

        return min;
    }

    public int findMin1(final List<Integer> a) {
        int index = 0;
        int lo=0, hi=a.size()-1;


        while(lo<=hi){
            int mid = lo + (hi-lo)/2;

            if(a.get(mid) > a.get(0)) {
                lo = mid + 1;
            } else {
                index = mid;
                hi = mid - 1;
            }
        }

        return a.get(index);
    }
}
