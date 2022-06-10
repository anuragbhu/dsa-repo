import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    // TC = O(m*n), AS = O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while(headA != null) {
            ListNode tempB = headB;
            while(tempB != null) {
                if(headA == tempB)
                    return tempB;
                tempB = tempB.next;
            }
            headA = headA.next;
        }
        return null;
    }

    // TC = O(m+n), AS = O(m)
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while(headB != null) {
            if(set.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }

    // TC = O(m+n), AS = O(1)
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linked-list
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }
        return a;
    }
}
