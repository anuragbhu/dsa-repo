public class NonRepeatingNumbers {
    // TC = O(n), AS = O(1)
    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }

        int setBit = xor & ~(xor - 1);
//        System.out.println(setBit);
        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++) {
            if((setBit & nums[i]) == setBit) {
                res[0] = res[0] ^ nums[i];
            } else {
                res[1] = res[1] ^ nums[i];
            }
        }

        if(res[0] > res[1]) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        return res;
    }

    // TC = O(n^2), AS = O(1)
    public int[] singleNumber1(int[] nums) {
        int[] res = new int[2];
        int k = 0;

        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }

            if(count != 2) {
                res[k] = nums[i];
                k++;
            }
        }

        if(res[0] > res[1]) {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 4};
        int[] result = singleNumber(arr);
        System.out.println(result[0] + " " + result[1]);
    }
}
