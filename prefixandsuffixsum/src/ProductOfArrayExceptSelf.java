public class ProductOfArrayExceptSelf {
    // TC = O(n), AS = O(2n)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, prod = 1;
        int[] leftProd = new int[n];
        int[] rightProd = new int[n];

        leftProd[0] = prod;
        for(int i = 1; i < n; i++) {
            prod *= nums[i-1];
            leftProd[i] = prod;
        }

        prod = 1;
        rightProd[n-1] = prod;
        for(int i = n-2; i >= 0; i--) {
            prod *= nums[i+1];
            rightProd[i] = prod;
        }

        for(int i = 0; i < n; i++) {
            nums[i] = leftProd[i] * rightProd[i];
        }
        return nums;
    }

    // TC = O(n), AS = O(1)
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length, prod = 1;
        int[] res = new int[n];

        res[0] = prod;
        for(int i = 1; i < n; i++) {
            prod *= nums[i-1];
            res[i] = prod;
        }

        prod = 1;
        res[n-1] *= prod;
        for(int i = n-2; i >= 0; i--) {
            prod *= nums[i+1];
            res[i] *= prod;
        }
        return res;
    }
}
