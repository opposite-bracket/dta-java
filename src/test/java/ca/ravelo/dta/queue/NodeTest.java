package ca.ravelo.dta.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {


    @Test
    public void test_Stack() {
        // when
        Node<Integer> sut = new Node<>(0);

        // then
        assertEquals(sut.getValue(), 0);
        assertNull(sut.getNext());
    }

    @Test
    public void test_setValue() {
        // given
        Node<Integer> sut = new Node<>(0);

        // when
        sut.setValue(1);

        // then
        assertEquals(sut.getValue(), 1);
        assertNull(sut.getNext());
    }

    @Test
    public void test_setNext() {
        // given
        Node<Integer> sut = new Node<>(0);
        Node<Integer> next = new Node<>(1);

        // when
        sut.setNext(next);

        // then
        assertEquals(sut.getValue(), 0);
        assertEquals(sut.getNext(), next);
    }


}