package ca.ravelo.dta.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void test_Node() {
        // when
        Node<Integer> sut = new Node<>(1);

        // then
        assertNull(sut.getNext());
        assertEquals(sut.getValue(), 1);
    }

    @Test
    void setValue() {
        // given
        Node<Integer> sut = new Node<>(1);

        assertNull(sut.getNext());
        assertEquals(sut.getValue(), 1);

        // when
        sut.setValue(2);

        // then
        assertEquals(sut.getValue(), 2);
    }

    @Test
    void setNext() {
        // given
        Node<Integer> sut = new Node<>(1);

        // when
        sut.setNext(new Node<>(2));

        // then
        assertEquals(sut.getNext().getValue(), 2);
    }
}