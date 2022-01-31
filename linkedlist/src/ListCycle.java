import java.util.HashMap;

public class ListCycle {
    public ListNode detectCycle(ListNode a) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode curr = a;

        while(curr != null) {
            if(map.containsKey(curr)) {
                return curr;
            } else {
                map.put(curr, curr.val);
                curr = curr.next;
            }
        }
        return null;
    }


}
