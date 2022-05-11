import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    // TC = O(n), AS = O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int index = 0; // For res;
        int[] res = new int[n-k+1];
        if (n < k)
            return res;

        // Maintains the decreasing order of max elements.
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < k; i++) {

            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.pollLast();

            deque.offerLast(nums[i]);
        }
        res[index++] = deque.peekFirst();

        for(int i = k; i < n; i++) {
            if(deque.peekFirst() == nums[i-k])
                deque.pollFirst();

            while(!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.pollLast();

            deque.offerLast(nums[i]);
            res[index++] = deque.peekFirst();
        }
        return res;
    }
}
