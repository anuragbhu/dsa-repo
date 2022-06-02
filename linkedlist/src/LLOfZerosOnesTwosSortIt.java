public class LLOfZerosOnesTwosSortIt {
    // TC = O(n), AS = O(1)
    static Node segregate(Node head) {
        if(head == null || head.next == null) return head;

        int countOne = 0, countTwo = 0, countZero = 0;
        Node curr = head;
        while(curr != null) {
            if((int)curr.data == 0)
                countZero++;
            else if((int) curr.data == 1)
                countOne++;
            else
                countTwo++;
            curr = curr.next;
        }

        curr = head;
        while(curr != null) {
            if(countZero > 0) {
                curr.data = 0;
                countZero--;
            } else if(countOne > 0) {
                curr.data = 1;
                countOne--;
            } else {
                curr.data = 2;
            }
            curr = curr.next;
        }
        return head;
    }
}
