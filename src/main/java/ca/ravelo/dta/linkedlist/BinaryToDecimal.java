package ca.ravelo.dta.linkedlist;

public class BinaryToDecimal {

    static public Integer binaryToDecimal(ListNode head) {

        Integer num = 0;
        ListNode c = head; // current

        while(c != null) {
            num = num * 2 + c.val;
            c = c.next;
        }

        return num;
    }

}
