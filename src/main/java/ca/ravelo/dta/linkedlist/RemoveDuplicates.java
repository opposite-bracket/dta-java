package ca.ravelo.dta.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    static public void removeDuplicates(ListNode head) {

        if (head == null) {
            return;
        }

        Set<Integer> d = new HashSet<>(); // duplicates
        d.add(head.val);
        ListNode c = head.next; // current
        ListNode p = head; // previous

        while(c != null) {

            if (d.contains(c.val)) {
                p.next = c.next;
                c.next = null;
                c = p.next;
            } else {
                d.add(c.val);
                p = c;
                c = c.next;
            }

        }

    }

}
