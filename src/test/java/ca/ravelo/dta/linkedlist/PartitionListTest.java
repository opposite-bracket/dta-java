package ca.ravelo.dta.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartitionListTest {

    @Test
    public void test_scenario1() {

        // given
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);

        // Input: head = [1,4,3,2,5,2], x = 3
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        // when
        ListNode newHead = PartitionList.partition(n1, 3);

        // then
        // Output: [1,2,2,4,3,5]
        assertEquals(n1, newHead); // 1 = 1
        assertEquals(n4.next, n6); // 2 -> 2
        assertEquals(n6.next, n2); // 2 -> 4
        assertEquals(n2.next, n3); // 4 -> 3
        assertEquals(n3.next, n5); // 3 -> 5
    }

    @Test
    public void test_scenario2() {

        // given
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);

        // Input: head = [2,1], x = 2
        n1.next = n2;

        // when
        ListNode newHead = PartitionList.partition(n1, 2);

        // then
        // Output: [1,2]
        assertEquals(n2, newHead); // 2 = 2
        assertEquals(n2.next, n1); // 2 -> 1
    }

}