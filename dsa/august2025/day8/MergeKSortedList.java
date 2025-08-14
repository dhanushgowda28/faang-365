public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode head : lists) {
            if (head == null)
                continue;
            res = mergeTwoLists(res, head);
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return (list1 != null) ? list1 : list2;
        }

        if (list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }

        list1.next = mergeTwoLists(list1.next, list2);
        return list1;
    }
}

class ListNode {

    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
      this.val = val;
    }

}
