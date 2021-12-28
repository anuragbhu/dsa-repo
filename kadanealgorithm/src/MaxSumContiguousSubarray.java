import java.util.List;

public class MaxSumContiguousSubarray {
    public int maxSubArray(final List<Integer> A) {

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            sum = Math.max(A.get(i), sum);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public int maxSubArray1(final List<Integer> A) {

        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < A.size(); i++) {
            int sum = 0;
            for(int j = i; j < A.size(); j++) {
                sum += A.get(j);
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
