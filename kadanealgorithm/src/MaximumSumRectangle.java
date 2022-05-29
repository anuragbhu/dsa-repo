public class MaximumSumRectangle {
    // TC = O(r*r*c), AS = O(c)
    int maximumSumRectangle(int R, int C, int M[][]) {
        int max = Integer.MIN_VALUE;
        int row = M.length;
        int col = M[0].length;

        for(int k = 0; k < row; k++) {
            int[] store = new int[col];
            for(int i = k; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    store[j] += M[i][j];
                }
                max = Math.max(maxSubArray(store), max);
            }
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            sum = Math.max(sum, nums[i]);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
