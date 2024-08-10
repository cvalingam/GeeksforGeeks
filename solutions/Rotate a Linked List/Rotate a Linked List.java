class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        if (head == null || k == 0)
            return head;

        Node newHead = head, lastNode = head, newHeadPrev = null;

        while (k-- > 0) {
            newHeadPrev = newHead;
            newHead = newHead.next;
        }

        if (newHead == null)
            return head;

        while (lastNode.next != null)
            lastNode = lastNode.next;

        lastNode.next = head;
        newHeadPrev.next = null;

        return newHead;
    }
}