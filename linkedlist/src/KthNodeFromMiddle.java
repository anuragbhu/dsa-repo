public class KthNodeFromMiddle {
    public int solve(ListNode A, int B) {
        ListNode curr = A;
        int count = 0; // For length of the LL

        // Finding length of LL
        while(curr != null) {
            count++;
            curr = curr.next;
        }

        if(count < B) return -1;

        //  Bth node from the middle towards the beginning of the Linked List A
        int mid = (count / 2) + 1 - B;
        count = 0;
        curr = A;

        while(curr != null) {
            count++;
            if(count == mid)
                return (int) curr.val;
            curr = curr.next;
        }
        return -1;
    }
}
