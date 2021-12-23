import java.util.List;

public class RotatedArray {
    public int findMin(final List<Integer> a) {

        int min = Integer.MAX_VALUE;

        for(Integer temp : a) {
            min = Math.min(temp, min);
        }

        return min;
    }
}
