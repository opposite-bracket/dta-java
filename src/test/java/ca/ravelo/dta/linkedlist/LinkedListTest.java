package ca.ravelo.dta.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    public void test_LinkedList_emptyConstructor() {
        // when
        LinkedList<Integer> sut = new LinkedList<>();

        // then
        assertNull(sut.getHead());
        assertEquals(sut.getHead(), sut.getTail());
        assertEquals(sut.getLength(), 0);
    }

    @Test
    public void test_LinkedList_withArgConstructor() {
        // when
        LinkedList<Integer> sut = new LinkedList<>(1);

        // then
        assertNotNull(sut.getHead());
        assertEquals(sut.getHead().getValue(), 1);
        assertEquals(sut.getHead(), sut.getTail());
        assertEquals(sut.getLength(), 1);
    }

    @Test
    public void test_append_noNodes() {
        // given
        LinkedList<Integer> sut = new LinkedList<>();

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
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        sut.append(0);
        sut.append(1);

        // then
        assertNotNull(sut.getHead());
        assertEquals(sut.getHead().getValue(), 0);
        assertEquals(sut.getTail().getValue(), 1);
        assertEquals(sut.getLength(), 2);
    }

}