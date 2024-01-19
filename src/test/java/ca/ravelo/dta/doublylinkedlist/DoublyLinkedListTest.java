package ca.ravelo.dta.doublylinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    public void test_DoublyLinkedList_emptyConstructor() {
        // when
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

        // then
        assertNull(sut.getHead());
        assertNull(sut.getTail());
        assertEquals(sut.getLength(), 0);
    }

    @Test
    public void test_LinkedList_withArgConstructor() {
        // when
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);

        // then
        assertNotNull(sut.getHead());
        assertEquals(sut.getHead(), sut.getTail());
        assertEquals(sut.getHead().getValue(), 0);
        assertEquals(sut.getLength(), 1);
    }

    @Test
    public void test_append_noNodes() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

        // when
        sut.append(0);

        // then
        assertNotNull(sut.getHead());
        assertEquals(sut.getHead().getValue(), 0);
        assertEquals(sut.getHead(), sut.getTail());
        assertEquals(sut.getLength(), 1);
    }

    @Test
    public void test_append_oneNode() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

        // when
        sut.append(0);
        sut.append(1);

        // then
        assertNotNull(sut.getHead());
        assertNotNull(sut.getTail());

        assertNull(sut.getHead().getPrev());
        assertNull(sut.getTail().getNext());

        assertEquals(sut.getHead().getValue(), 0);
        assertEquals(sut.getTail().getValue(), 1);

        assertEquals(sut.getHead().getNext(), sut.getTail());
        assertEquals(sut.getTail().getPrev(), sut.getHead());

        assertEquals(sut.getLength(), 2);
    }

}