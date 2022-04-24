import java.util.ArrayList;

public class MaximumOnesAfterModification {
    // TC = O(n^2), AS = O(1)
    public int solve(ArrayList<Integer> A, int B) {
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < A.size(); i++) {
            int count = 0, occur = B;
            for(int j = i; j < A.size(); j++) {
                if(A.get(j) == 0 && occur > 0) {
                    count++; occur--;
                } else if(A.get(j) == 1) {
                    count++;
                } else {
                    break;
                }
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
