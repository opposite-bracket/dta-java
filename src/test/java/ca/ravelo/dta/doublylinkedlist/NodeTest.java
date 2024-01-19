package ca.ravelo.dta.doublylinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void test_Node() {
        // when
        Node<Integer> sut = new Node<>(0);

        // then
        assertEquals(sut.getValue(), 0);
        assertNull(sut.getPrev());
        assertNull(sut.getNext());
    }

    @Test
    void node_setValue() {
        // given
        Node<Integer> sut = new Node<>(0);

        // when
        sut.setValue(1);

        // then
        assertEquals(sut.getValue(), 1);
        assertNull(sut.getPrev());
        assertNull(sut.getNext());
    }

    @Test
    void node_setPrev() {
        // given
        Node<Integer> prev = new Node<>(-1);
        Node<Integer> sut = new Node<>(0);

        // when
        sut.setPrev(prev);

        // then
        assertNotNull(sut.getPrev());
        assertEquals(sut.getPrev().getValue(), -1);
    }

    @Test
    void test_setNext() {
        // given
        Node<Integer> next = new Node<>(1);
        Node<Integer> sut = new Node<>(0);

        // when
        sut.setNext(next);

        // then
        assertNotNull(sut.getNext());
        assertEquals(sut.getNext().getValue(), next.getValue());
    }
}