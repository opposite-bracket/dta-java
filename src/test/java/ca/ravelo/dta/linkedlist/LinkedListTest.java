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

    @Test
    public void test_prepend_noNodes() {
        // given
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        sut.prepend(0);

        // then
        assertNotNull(sut.getHead());
        assertEquals(sut.getHead().getValue(), 0);
        assertEquals(sut.getHead(), sut.getTail());
        assertEquals(sut.getLength(), 1);
    }

    @Test
    public void test_prepend_oneNode() {
        // given
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        sut.prepend(0);
        sut.prepend(1);

        // then
        assertNotNull(sut.getHead());
        assertEquals(sut.getHead().getValue(), 1);
        assertEquals(sut.getTail().getValue(), 0);
        assertEquals(sut.getLength(), 2);
    }

    @Test
    public void test_removeLast_noNodes() {
        // given
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        Node<Integer> removedNode = sut.removeLast();

        // then
        assertNull(removedNode);
    }

    @Test
    public void test_removeLast_oneNode() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);

        // when
        Node<Integer> removedNode = sut.removeLast();

        // then
        assertNotNull(removedNode);
        assertEquals(removedNode.getValue(), 0);
        assertNull(sut.getHead());
        assertEquals(sut.getHead(), sut.getTail());
        assertEquals(sut.getLength(), 0);
    }

    @Test
    public void test_removeLast_twoNode() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);
        sut.append(1);

        // when
        Node<Integer> removedNode = sut.removeLast();

        // then
        assertNotNull(removedNode);
        assertEquals(removedNode.getValue(), 1);
        assertNotNull(sut.getHead());
        assertEquals(sut.getHead(), sut.getTail());
        assertEquals(sut.getLength(), 1);
    }

    @Test
    public void test_removeFirst_noNodes() {
        // given
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        Node<Integer> removedNode = sut.removeFirst();

        // then
        assertNull(removedNode);
        assertNull(sut.getHead());
        assertEquals(sut.getHead(), sut.getTail());
        assertEquals(sut.getLength(), 0);
    }

    @Test
    public void test_removeFirst_oneNode() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);

        // when
        Node<Integer> removedNode = sut.removeFirst();

        // then
        assertNotNull(removedNode);
        assertEquals(removedNode.getValue(), 0);
        assertNull(sut.getHead());
        assertEquals(sut.getHead(), sut.getTail());
        assertEquals(sut.getLength(), 0);
    }

    @Test
    public void test_removeFirst_twoNodes() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);
        sut.append(1);

        // when
        Node<Integer> removedNode = sut.removeFirst();

        // then
        assertNotNull(removedNode);
        assertEquals(removedNode.getValue(), 0);
        assertNotNull(sut.getHead());
        assertEquals(sut.getHead(), sut.getTail());
        assertEquals(sut.getLength(), 1);
    }

    @Test
    public void test_get_underZeroIndex() {
        // given
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        Node<Integer> foundNode = sut.get(-1);

        // then
        assertNull(foundNode);
    }

    @Test
    public void test_get_equalsLength() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);

        // when
        Node<Integer> foundNode = sut.get(sut.getLength());

        // then
        assertNull(foundNode);
    }

    @Test
    public void test_get_greaterThanLength() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);

        // when
        Node<Integer> foundNode = sut.get(sut.getLength() + 1);

        // then
        assertNull(foundNode);
    }


    @Test
    public void test_get_noNodes() {
        // given
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        Node<Integer> foundNode = sut.get(0);

        // then
        assertNull(foundNode);
    }

    @Test
    public void test_get_oneNode() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);

        // when
        Node<Integer> foundNode = sut.get(0);

        // then
        assertNotNull(foundNode);
        assertEquals(foundNode.getValue(), 0);
    }

    @Test
    public void test_get_twoNodes() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);
        sut.append(1);

        // when
        Node<Integer> foundNode = sut.get(1);

        // then
        assertNotNull(foundNode);
        assertEquals(foundNode.getValue(), 1);
        assertEquals(foundNode, sut.getTail());
    }
}