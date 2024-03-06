package ca.ravelo.dta.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseBetweenTest {

    @Test
    public void test_reverseBetween_scenario1() {
        // given
        // Input: LL: 1 -> 2 -> 3 -> 4 -> 5
        //        start: 1
        //        end: 3
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // when
        ReverseBetween.reverseBetween(n1, 1, 3);

        // then
        // Output: 1 -> 4 -> 3 -> 2 -> 5
        assertEquals(1, n1.val);
        assertEquals(4, n1.next.val);
        assertEquals(3, n1.next.next.val);
        assertEquals(2, n1.next.next.next.val);
        assertEquals(5, n1.next.next.next.next.val);
    }

    @Test
    public void test_reverseBetween_scenario2() {
        // given
        // Input: LL: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //        start: 1
        //        end: 4
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        // when
        ReverseBetween.reverseBetween(n1, 1, 4);

        // then
        // Output: 1 -> 5 -> 4 -> 3 -> 2 -> 6
        assertEquals(1, n1.val);
        assertEquals(5, n1.next.val);
        assertEquals(4, n1.next.next.val);
        assertEquals(3, n1.next.next.next.val);
        assertEquals(2, n1.next.next.next.next.val);
        assertEquals(6, n1.next.next.next.next.next.val);
    }

}