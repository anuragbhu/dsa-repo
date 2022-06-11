public class AddTwoNumbers {
    // TC = O(n), AS = O(n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;

            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            ListNode next = new ListNode(sum);
            curr.next = next;

            // next
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int sum = carry + l1.val;

            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            curr.next = new ListNode(sum);
            // next
            curr = curr.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int sum = carry + l2.val;

            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            curr.next = new ListNode(sum);
            // next
            curr = curr.next;
            l2 = l2.next;
        }

        if(carry != 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
