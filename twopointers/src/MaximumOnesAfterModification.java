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

    // TC = O(n), AS = O(1)
    public int solve1(ArrayList<Integer> A, int B) {
        int start = 0, end = 0;
        int result = Integer.MIN_VALUE;

        while(end < A.size()) {
            if(A.get(end) == 0) {
                B--;
            }
            while(B < 0) {
                if(A.get(start) == 0) {
                    B++;
                }
                start++;
            }
            result = Math.max(result, end - start + 1);
            end++;
        }
        return result;
    }
}
