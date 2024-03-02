package ca.ravelo.dta.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartitionListTest {

    @Test
    public void test_scenario1() {

        // given
        PartitionList.ListNode n1 = new PartitionList.ListNode(1);
        PartitionList.ListNode n2 = new PartitionList.ListNode(4);
        PartitionList.ListNode n3 = new PartitionList.ListNode(3);
        PartitionList.ListNode n4 = new PartitionList.ListNode(2);
        PartitionList.ListNode n5 = new PartitionList.ListNode(5);
        PartitionList.ListNode n6 = new PartitionList.ListNode(2);

        // Input: head = [1,4,3,2,5,2], x = 3
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        // when
        PartitionList.ListNode newHead = PartitionList.partition(n1, 3);

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
        PartitionList.ListNode n1 = new PartitionList.ListNode(2);
        PartitionList.ListNode n2 = new PartitionList.ListNode(1);

        // Input: head = [2,1], x = 2
        n1.next = n2;

        // when
        PartitionList.ListNode newHead = PartitionList.partition(n1, 2);

        // then
        // Output: [1,2]
        assertEquals(n2, newHead); // 2 = 2
        assertEquals(n2.next, n1); // 2 -> 1
    }

}