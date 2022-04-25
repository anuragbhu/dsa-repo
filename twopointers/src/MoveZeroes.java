public class MoveZeroes {
    // TC = O(n), SC = O(n)
    public void moveZeroes(int[] nums) {
        int[] temp = new int[nums.length];
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                temp[j] = nums[i];
                j++;
            }
        }

        for(int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
    }
    // TC = O(n), SC = O(1)
    public void moveZeroes1(int[] nums) {
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
