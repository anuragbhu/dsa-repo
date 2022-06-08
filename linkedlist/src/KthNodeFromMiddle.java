public class KthNodeFromMiddle {
    // TC = O(n), AS = O(1)
    public int solve(ListNode A, int B) {
        int mid = getSize(A) / 2;
        int index = mid - B;
        if(index < 0)
            return -1;

        int idx = 0;
        while(A != null) {
            if(index == idx) {
                return A.val;
            }
            idx++;
            A = A.next;
        }
        return -1;
    }

    private int getSize(ListNode head) {
        int size = 0;
        while(head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
