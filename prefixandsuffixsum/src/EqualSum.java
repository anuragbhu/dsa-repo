public class EqualSum {
    // TC = O(n^2), AS = O(1)
    String equilibrium(int[] arr, int n) {
        if(n == 1) return "YES";

        String ans = "NO";
        int prefixSum = 0, suffixSum = 0;
        for(int i = 1; i < n; i++) {
            prefixSum += arr[i-1];
            suffixSum = 0;
            for(int j = i+1; j < n; j++) {
                suffixSum += arr[j];
            }

            if(prefixSum == suffixSum)
                return "YES";
        }
        return ans;
    }

    // TC = O(n), AS = O(1)
    String equilibrium1(int[] arr, int n) {
        if(n == 1) return "YES";

        String ans = "NO";
        int prefixSum = 0, suffixSum = 0;

        for(int i = 1; i < n; i++) {
            suffixSum += arr[i];
        }

        for(int i = 1; i < n; i++) {
            prefixSum += arr[i-1];
            suffixSum -= arr[i];

            if(prefixSum == suffixSum)
                return "YES";
        }

        return ans;
    }
}
