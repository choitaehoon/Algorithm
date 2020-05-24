package solve;

public class AddTwoNumbers {

    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l1Location = l1;
        ListNode l2Location = l2;
        ListNode current = head;

        int moveNumber = 0;
        while (l1Location != null | l2Location != null) {
            int x = l1Location != null ? l1Location.val : 0;
            int y = l2Location != null ? l2Location.val : 0;
            int sum = moveNumber + x + y;
            moveNumber = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1Location != null) l1Location = l1Location.next;
            if (l2Location != null) l2Location = l2Location.next;
        }

        if (moveNumber > 0)
            current.next = new ListNode(moveNumber);

        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}