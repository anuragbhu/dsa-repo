import java.util.ArrayList;

public class WoodCuttingMadeEasy {
    // algorithm with O(nlog n) runtime complexity.
    public int solve(ArrayList<Integer> A, int B) {
        int low = 0, high = 0, res = 0;

        // Finding high index
        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) > high)
                high = A.get(i);
        }

        while(low <= high) {
            int mid = low + (high - low)/2;
            long tempResult = 0; // Not possible for int for large value.

            for(int i = 0; i < A.size(); i++) {
                if((A.get(i) - mid) > 0)
                    tempResult += A.get(i) - mid;
            }

            if(tempResult == B) {
                return mid;
            } else if(tempResult > B) {
                res = Math.max(res, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
