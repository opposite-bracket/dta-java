package ca.ravelo.dta.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryToDecimalTest {
    @Test
    public void test_binaryToDecimal_scenario1() {
        // given
        // Input:
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;

        // when
        Integer actual = BinaryToDecimal.binaryToDecimal(n1);

        // then
        assertEquals(5, actual);
    }
}