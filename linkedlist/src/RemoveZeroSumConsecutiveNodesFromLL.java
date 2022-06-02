import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesFromLL {
    // TC = O(n), AS = O(n)
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int prefixSum = 0;
        Map<Integer, ListNode> seen = new HashMap<>();
        seen.put(prefixSum, dummy);

        ListNode curr = head;
        while(curr != null) {
            prefixSum += curr.val;
            seen.put(prefixSum, curr);
            curr = curr.next;
        }

        prefixSum = 0;
        curr = dummy;
        while(curr != null) {
            prefixSum += curr.val;
            curr.next = seen.get(prefixSum).next;
            curr = curr.next;
        }

        return dummy.next;
    }
}
