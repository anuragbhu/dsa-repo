public class SortColors {
    public void sortColors(int[] nums) {
        int zeroes = 0, ones = 0, twos = 0;

        for(int i = 0; i < nums.length; i++) {
            switch(nums[i]) {
                case 0: zeroes++;
                    break;
                case 1: ones++;
                    break;
                case 2: twos++;
                    break;
            }
        }

        int index = 0;
        for(int i = 0; i < zeroes; i++) {
            nums[index] = 0;
            index++;
        }

        for(int i = 0; i < ones; i++) {
            nums[index] = 1;
            index++;
        }

        for(int i = 0; i < twos; i++) {
            nums[index] = 2;
            index++;
        }
    }

    public void sortColors1(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1;

        while(mid <= high) {
            switch(nums[mid]) {
                case 0:
                    swap(nums, low, mid);
                    low++; mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
