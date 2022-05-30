public class SortColors {
    // TC = O(n), As = O(1)
    public void sortColors(int[] nums) {
        int countZero = 0, countOne = 0, countTwo = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                countZero++;
            else if(nums[i] == 1)
                countOne++;
            else
                countTwo++;
        }

        int k = 0;
        for(int i = 0; i < countZero; i++) {
            nums[k++] = 0;
        }

        for(int i = 0; i < countOne; i++) {
            nums[k++] = 1;
        }

        for(int i = 0; i < countTwo; i++) {
            nums[k++] = 2;
        }
    }

    // TC = O(n), As = O(1)
    public void sortColors1(int[] nums) {
        int low = 0, mid = 0, high = nums.length-1;
        while(mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if(nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
