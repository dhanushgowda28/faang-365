import java.util.List;

public class SwapNodesinPairs {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= 8; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        head = swapPairs(head);
        nodePrint(head);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode sec = head.next;

        first.next = swapPairs(sec.next);
        sec.next = first;

        return sec;

    }

    public static void nodePrint(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

}
