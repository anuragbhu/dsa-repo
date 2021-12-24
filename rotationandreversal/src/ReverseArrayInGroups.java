import java.util.ArrayList;

public class ReverseArrayInGroups {
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {

        for(int i = 0; i < n; i += k) {

            int start = i;
            int end = Math.min(n-1, (i + k - 1));
            while((start < end) && (end < n)) {
                int temp = arr.get(start);
                arr.set(start, arr.get(end));
                arr.set(end, temp);
                start++;
                end--;
            }
        }
    }
}
