public class RotateArray {
    // TC = O(n*k), AS = O(1)
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if(k < 0) // In case k < 0
            k = k + n;

        for(int i = 0; i < k; i++) {
            int firstValue = nums[nums.length-1];
            for(int j = nums.length-1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = firstValue;
        }

    }

    // TC = O(n), AS = O(n)
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int rotate = k % n;

        if(k < 0) // In case k < 0
            k = k + n;

        int[] temp = new int[rotate];
        int j = 0;

        // Store k elements
        for(int i = n-rotate; i < n; i++) {
            temp[j] = nums[i];
            j++;
        }
        // Shift rest of the nums[]
        for(int i = n-1; i >= rotate; i--) {
            nums[i] = nums[i-rotate];
        }
        // Store back the k elements
        for(int i = 0; i < rotate; i++) {
            nums[i] = temp[i];
        }

    }

    // TC = O(n), AS = O(1)
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Important in case k > n

        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
    }

    private static void reverseArray(int[] nums, int start, int end){
        while (start < end)
        {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
