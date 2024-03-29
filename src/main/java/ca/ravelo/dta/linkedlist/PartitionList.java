package ca.ravelo.dta.linkedlist;

// Partition List
// https://leetcode.com/problems/partition-list/description/
public class PartitionList {

    static public ListNode partition(ListNode head, Integer x) {

        if (head == null) {
            return null;
        }

        ListNode fl = new ListNode(0);
        ListNode fr = new ListNode(0);
        ListNode l = fl;
        ListNode r = fr;
        ListNode c = head;

        while(c != null) {
            if (c.val < x) {
                l.next = c;
                l = c;
            } else {
                r.next = c;
                r = c;
            }

            c = c.next;
        }

        l.next = fr.next;
        r.next = null;

        return fl.next;
    }

}
