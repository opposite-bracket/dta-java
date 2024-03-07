package ca.ravelo.dta.doublylinkedlist;

import org.w3c.dom.NodeList;

public class SwapPairs {

    private ListNode head;
    private int length;

    class ListNode {
        int value;
        ListNode next;
        ListNode prev;

        ListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[val=" + value + (prev != null ? ", prev=" + prev.value : "") + (next != null ? ", next=" + next.value : "") + "]";
        }
    }

    public SwapPairs() {
        length = 0;
    }

    public SwapPairs(int value) {
        ListNode newNode = new ListNode(value);
        head = newNode;
        length = 1;
    }

    public ListNode getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        StringBuilder output = new StringBuilder();
        ListNode temp = head;
        while (temp != null) {
            output.append(temp.value);
            if (temp.next != null) {
                output.append(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println(output.toString());
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        ListNode newNode = new ListNode(value);
        if (length == 0) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        length++;
    }

    public void swapPairs() {
        if (length < 2) {
            return;
        }

        ListNode d = new ListNode(0);
        d.next = head;
        head.prev = d;

        ListNode p = head; // previous
        ListNode c = head.next; // current

        while (p != null && c != null) {
            ListNode n = c.next;
            // move c out
            p.next = n;
            if (n != null) {
                n.prev = p;
            }

            // move c back
            c.next = p;
            c.prev = p.prev;

            // connect c
            p.prev.next = c;
            p.prev = c;

            p = n;
            if (n != null) {
                c = n.next;
            }
        }

        head = d.next;
        head.prev = null;

    }

}
