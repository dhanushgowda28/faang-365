class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class PartitionList {

    public static ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0); // Dummy node for < x
        ListNode moreDummy = new ListNode(0); // Dummy node for >= x
        ListNode lessTail = lessDummy;
        ListNode moreTail = moreDummy;

        ListNode ptr = head;

        while (ptr != null) {
            ListNode next = ptr.next;
            ptr.next = null; // Detach to avoid incorrect links

            if (ptr.val < x) {
                lessTail.next = ptr;
                lessTail = ptr;
            } else {
                moreTail.next = ptr;
                moreTail = ptr;
            }

            ptr = next;
        }

        // Connect the two lists
        lessTail.next = moreDummy.next;

        return lessDummy.next; // Skip dummy head
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Input: [1, 4, 3, 2, 5, 2]
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 4;
        ListNode result = partition(head, x);
        printList(result); // Output: 1 -> 2 -> 2 -> 4 -> 3 -> 5 -> null
    }
}
