package ca.ravelo.dta.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {

    @Test
    public void test_scenario1() {
        // l1 = [2,4,3]
        ListNode l1n1 = new ListNode(2);
        ListNode l1n2 = new ListNode(4);
        ListNode l1n3 = new ListNode(3);
        l1n1.next = l1n2;
        l1n2.next = l1n3;

        // l2 = [5,6,4]
        ListNode l2n1 = new ListNode(5);
        ListNode l2n2 = new ListNode(6);
        ListNode l2n3 = new ListNode(4);
        l2n1.next = l2n2;
        l2n2.next = l2n3;

        ListNode addedListNode = AddTwoNumbers.addTwoNumbers(l1n1, l2n1);

        // [7,0,8]
        assertEquals(7, addedListNode.val);
        assertEquals(0, addedListNode.next.val);
        assertEquals(8, addedListNode.next.next.val);
    }

    @Test
    public void test_scenario2() {
        // l1 = [0]
        ListNode l1n1 = new ListNode(0);

        // l2 = [5,6,4]
        ListNode l2n1 = new ListNode(0);

        ListNode addedListNode = AddTwoNumbers.addTwoNumbers(l1n1, l2n1);

        // [0]
        assertEquals(0, addedListNode.val);
    }

    @Test
    public void test_scenario3() {
        // l1 = [9,9,9,9,9,9,9]
        ListNode l1n1 = new ListNode(9);
        ListNode l1n2 = new ListNode(9);
        ListNode l1n3 = new ListNode(9);
        ListNode l1n4 = new ListNode(9);
        ListNode l1n5 = new ListNode(9);
        ListNode l1n6 = new ListNode(9);
        ListNode l1n7 = new ListNode(9);
        l1n1.next = l1n2;
        l1n2.next = l1n3;
        l1n3.next = l1n4;
        l1n4.next = l1n5;
        l1n5.next = l1n6;
        l1n6.next = l1n7;

        // l2 = [9,9,9,9]
        ListNode l2n1 = new ListNode(9);
        ListNode l2n2 = new ListNode(9);
        ListNode l2n3 = new ListNode(9);
        ListNode l2n4 = new ListNode(9);
        l2n1.next = l2n2;
        l2n2.next = l2n3;
        l2n3.next = l2n4;

        ListNode addedListNode = AddTwoNumbers.addTwoNumbers(l1n1, l2n1);

        // [8,9,9,9,0,0,0,1]
        assertEquals(8, addedListNode.val);
        assertEquals(9, addedListNode.next.val);
        assertEquals(9, addedListNode.next.next.val);
        assertEquals(9, addedListNode.next.next.next.val);
        assertEquals(0, addedListNode.next.next.next.next.val);
        assertEquals(0, addedListNode.next.next.next.next.next.val);
        assertEquals(0, addedListNode.next.next.next.next.next.next.val);
        assertEquals(1, addedListNode.next.next.next.next.next.next.next.val);
    }

}