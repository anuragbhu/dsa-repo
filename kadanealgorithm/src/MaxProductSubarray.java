import java.util.List;

public class MaxProductSubarray {
    // TC = O(n), AS = O(1)
    public int maxProduct1(int[] nums) {
        int n = nums.length;
        int prod = 1;
        int maxProd = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) { // Left to Right
            prod *= nums[i];
            maxProd = Math.max(prod, maxProd);
            if(nums[i] == 0)
                prod = 1;
        }

        prod = 1;
        for(int i = n-1; i >= 0; i--) { // Right  to Left
            prod *= nums[i];
            maxProd = Math.max(prod, maxProd);
            if(nums[i] == 0)
                prod = 1;
        }
        return maxProd;
    }

    // TC = O(n^2), AS = O(1)
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int prod = 1;
            for(int j = i; j < n; j++) {
                prod *= nums[j];
                maxProd = Math.max(prod, maxProd);
            }
        }
        return maxProd;
    }
}
