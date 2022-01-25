import java.util.HashMap;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode headACurr = headA;
        ListNode headBCurr = headB;

        while(headACurr != null) {
            ListNode temp = headBCurr;
            while(temp != null) {
                if(headACurr == temp)
                    return headACurr;
                temp = temp.next;
            }
            headACurr = headACurr.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        ListNode headACurr = headA;
        ListNode headBCurr = headB;

        HashMap<ListNode, Integer> map = new HashMap<>();

        while(headACurr != null) {
            map.put(headACurr, headACurr.val);
            headACurr = headACurr.next;
        }

        while(headBCurr != null) {
            if (map.containsKey(headBCurr)) {
                return headBCurr;
            }
            headBCurr = headBCurr.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while( a != b){
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }
        return a;
    }
}
