import java.util.ArrayList;

public class MaximumSubarraySumAfterKConcatenation {
    public static long maxSubSumKConcat(ArrayList<Integer> arr, int n, int k) {
        int[] temp = new int[n*k];
        int j = 0;
        for(int i = 0; i < temp.length; i++) {
            temp[i] = arr.get(j);
            j++;

            if(j == n) j = 0;
        }

        long maxSum = Long.MIN_VALUE;
        long sum = 0;

        for(int i = 0; i < temp.length; i++) {
            sum += temp[i];
            sum = Math.max(temp[i], sum);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static long maxSubSumKConcat1(ArrayList<Integer> arr, int n, int k) {

        long maxSum = Long.MIN_VALUE;
        long sum = 0;

        int concat = 0, i = 0;
        while (concat < k) {
            sum += arr.get(i);
            sum = Math.max(arr.get(i), sum);
            maxSum = Math.max(maxSum, sum);
            i++;
            if (i == arr.size()){
                concat++;
                i = 0;
            }
        }
        return maxSum;
    }


}
