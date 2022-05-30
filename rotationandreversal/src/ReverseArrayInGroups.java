import java.util.ArrayList;

public class ReverseArrayInGroups {
    // TC = O(n), AS = O(1)
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        for(int i = 0; i < n; i += k) {
            reverse(arr, i, Math.min(i+k-1, n-1));
        }
    }

    void reverse(ArrayList<Integer> arr, int start, int end) {
        while(start < end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);

            start++;
            end--;
        }
    }
}
