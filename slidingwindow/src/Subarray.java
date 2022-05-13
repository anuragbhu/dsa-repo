public class Subarray {
    // TC = O(n^3), AS = (1)
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int len = arr.length;

        System.out.println("All Non-empty Subarrays");
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                for(int k = i; k <=j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }
}
