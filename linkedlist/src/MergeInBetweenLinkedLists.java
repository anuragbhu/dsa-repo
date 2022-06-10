public class MergeInBetweenLinkedLists {
    // TC = O(m+n), AS = O(1)
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // list1 and list2 cannot be null
        ListNode ans = list1;

        ListNode aNode = null;
        ListNode bNode = null;

        int index = 0;
        while(list1 != null) {
            if(index == a-1)
                aNode = list1;

            if(index == b+1)
                bNode = list1;

            list1 = list1.next;
            index++;
        }

        aNode.next = list2;

        while(list2.next != null) {
            list2 = list2.next;
        }

        list2.next = bNode;

        return ans;
    }
}
