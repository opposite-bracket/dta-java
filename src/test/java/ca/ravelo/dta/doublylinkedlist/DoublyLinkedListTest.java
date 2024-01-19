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

}