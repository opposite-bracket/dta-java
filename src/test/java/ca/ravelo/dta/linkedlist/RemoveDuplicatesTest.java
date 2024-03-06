package ca.ravelo.dta.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {


    @Test
    public void test_removeDuplicates_scenario1(){
        // given
        // Input: LinkedList: 1 -> 2 -> 3 -> 1 -> 4 -> 2 -> 5
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        // when
        RemoveDuplicates.removeDuplicates(n1);

        // then
        // Output: LinkedList: 1 -> 2 -> 3 -> 4 -> 5
        assertEquals(1, n1.val);
        assertEquals(2, n1.next.val);
        assertEquals(3, n1.next.next.val);
        assertEquals(4, n1.next.next.next.val);
        assertEquals(5, n1.next.next.next.next.val);
    }

}