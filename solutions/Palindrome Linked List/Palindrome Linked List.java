class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        if (head == null || head.next == null) // edge case
            return true;

        // find middle of linked list
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        // Reverse the half of linked list from mid.next
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node front = curr.next;

        while (curr != null && curr.next != null) {
            curr.next = prev;
            prev = curr;
            curr = front;
            front = front.next;
        }

        // Check that two halves are equal or not
        slow = head;
        while (slow != null && curr != null) {
            if (slow.data != curr.data)
                return false;
            slow = slow.next;
            curr = curr.next;
        }
        return true;
    }
}