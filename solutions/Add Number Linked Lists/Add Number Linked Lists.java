class Solution {
    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2) {
        Node first = reverseList(num1);
        Node second = reverseList(num2);

        Node dummy = new Node(-1);
        Node temp = dummy;
        int carry = 0;

        while (first != null || second != null || carry == 1) {
            int sum = 0;

            if (first != null) {
                sum += first.data;
                first = first.next;
            }

            if (second != null) {
                sum += second.data;
                second = second.next;
            }

            sum += carry;
            carry = sum / 10;
            Node newNode = new Node(sum % 10);
            temp.next = newNode;
            temp = temp.next;
        }

        Node ans = reverseList(dummy.next);

        while (ans != null && ans.data == 0)
            ans = ans.next;

        return (ans == null) ? new Node(0) : ans;
    }

    static Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;

        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}