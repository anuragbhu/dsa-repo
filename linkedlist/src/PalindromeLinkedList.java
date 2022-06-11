import java.util.ArrayList;

public class PalindromeLinkedList {
    // TC = O(n), AS = O(n)
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while(head != null) {
            arr.add(head.val);
            head = head.next;
        }

        int i = 0, j = arr.size()-1;
        while(i < j) {
            if(arr.get(i) != arr.get(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    // TC = O(n), AS = O(1)
    public boolean isPalindrome1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverseList(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
