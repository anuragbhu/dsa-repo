public class ValidMountainArray {
    // TC = O(n), SC = O(1)
    public boolean validMountainArray(int[] arr) {
        // There should be only 1 peak element in the array.
        // We should have both the sequences in the array - i.e. strictly increasing and then strictly decreasing
        if(arr.length < 3)
            return false;

        int left = 0, right = arr.length-1;

        while(left < arr.length-1) {
            if(arr[left] < arr[left + 1]) left++;
            else break;
        }

        if(left == arr.length-1) return false; // only strictly increasing -> 0 1 2 5 6 8 9

        while(right > 0) {
            if(arr[right - 1] > arr[right]) right--;
            else break;
        }

        if(right == 0) return false; // only strictly decreasing -> 9 6 5 3 2 1 0

        return left == right; // (both stops at peak element)
        // if not then not strictly increasing or strictly decreasing or both.
    }
}
