package ca.ravelo.dta.linkedlist;

public class ReverseBetween {

    static public void reverseBetween(ListNode head, int startIndex, int endIndex) {

        if (head == null) {
            return;
        }

        int pos = 0;
        ListNode dummy = new ListNode(); // Partition Start
        dummy.next = head;

        ListNode ps = head;
        ListNode p = head; // Prior to moving node

        for (int i = 0; i < startIndex; i++) {
            p = p.next;
            pos++;
        }

        for (; pos < endIndex; pos++) {
            ListNode m = p.next; // Moving node

            p.next = m.next;
            m.next = ps.next;
            ps.next = m;
        }

        head = ps;
    }

}
