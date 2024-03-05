package ca.ravelo.dta.linkedlist;

public class AddTwoNumbers {

    // Fails with Exception on scenario 4
    // java.lang.NumberFormatException: For input string: "9999999991"
    static public ListNode addTwoNumbers_firstAttempt(ListNode l1, ListNode l2) {

        StringBuilder s1 = new StringBuilder();
        ListNode c1 = l1;

        StringBuilder s2 = new StringBuilder();
        ListNode c2 = l2;

        while(c1 != null) {
            s1.insert(0, c1.val);
            c1 = c1.next;
        }

        while(c2 != null) {
            s2.insert(0, c2.val);
            c2 = c2.next;
        }

        String sum = String.valueOf(Integer.parseInt(s1.toString()) + Integer.parseInt(s2.toString()));
        ListNode fl = new ListNode(0);
        ListNode l = fl;
        for (int i = sum.length() - 1; i >= 0; i--) {
            l.next = new ListNode(sum.charAt(i) - '0');
            l = l.next;
        }

        return fl.next;
    }

    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode fn = new ListNode(0);
        ListNode n = fn;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int d1 = l1 != null ? l1.val : 0;
            int d2 = l2 != null ? l2.val : 0;

            int sum = d1 + d2 + carry;
            int d = sum % 10;
            carry = sum / 10;

            n.next = new ListNode(d);
            n = n.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        return fn.next;
    }

}
