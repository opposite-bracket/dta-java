package ca.ravelo.dta.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindKthNodeFromEndTest {

    @Test
    public void test_kthNodeFromEnd() {
        // given
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);

        // when
        Node<?> actual1 = FindKthNodeFromEnd.kthNodeFromEnd(n1, 2);
        Node<?> actual2 = FindKthNodeFromEnd.kthNodeFromEnd(n1, 5);
        Node<?> actual3 = FindKthNodeFromEnd.kthNodeFromEnd(n1, 6);

        // then
        assertEquals(n4, actual1);
        assertEquals(n1, actual2);
        assertNull(actual3);
    }

}