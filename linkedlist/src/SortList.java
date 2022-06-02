public class SortList {
    // TC = O(nlogn), AS = O(logn) --- Stack memory for recursion call
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // step 1. cut the list to two halves
        // prev record node before slow
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //change pre next to null, make two sub list(head to prev, slow to fast)
        prev.next = null;

        // step 2. sort each half
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(slow);

        // step 3. merge list1 and list2
        return merge(list1, list2);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0), point = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                point.next = list1;
                list1 = list1.next;
            } else {
                point.next = list2;
                list2 = list2.next;
            }
            point = point.next;
        }

        if (list1 != null)
            point.next = list1;

        if (list2 != null)
            point.next = list2;

        return dummyHead.next;
    }
}
