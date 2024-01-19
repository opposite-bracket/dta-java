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

    @Test
    public void test_prepend_noNodes() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

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
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

        // when
        sut.prepend(0);
        sut.prepend(1);

        // then
        assertNotNull(sut.getHead());
        assertNotNull(sut.getTail());

        assertNull(sut.getHead().getPrev());
        assertNull(sut.getTail().getNext());

        assertEquals(sut.getHead().getValue(), 1);
        assertEquals(sut.getTail().getValue(), 0);

        assertEquals(sut.getHead().getNext(), sut.getTail());
        assertEquals(sut.getTail().getPrev(), sut.getHead());

        assertEquals(sut.getLength(), 2);
    }

    @Test
    public void test_removeLast_noNodes() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

        // when
        Node<Integer> removedNode = sut.removeLast();

        // then
        assertNull(removedNode);
    }

    @Test
    public void test_removeLast_oneNode() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);

        // when
        Node<Integer> removedNode = sut.removeLast();

        // then
        assertNotNull(removedNode);
        assertNull(removedNode.getPrev());
        assertNull(removedNode.getNext());
        assertEquals(removedNode.getValue(), 0);

        assertNull(sut.getHead());
        assertEquals(sut.getHead(), sut.getTail());
        assertEquals(sut.getLength(), 0);
    }

    @Test
    public void test_removeLast_twoNode() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);
        sut.append(1);

        // when
        Node<Integer> removedNode = sut.removeLast();

        // then
        assertNotNull(removedNode);
        assertNull(removedNode.getPrev());
        assertNull(removedNode.getNext());
        assertEquals(removedNode.getValue(), 1);

        assertNotNull(sut.getHead());
        assertEquals(sut.getHead(), sut.getTail());
        assertEquals(sut.getHead().getValue(), 0);

        assertNull(sut.getHead().getPrev());
        assertNull(sut.getTail().getNext());

        assertEquals(sut.getLength(), 1);
    }

    @Test
    public void test_removeFirst_noNodes() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

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
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);

        // when
        Node<Integer> removedNode = sut.removeFirst();

        // then
        assertNotNull(removedNode);
        assertNull(removedNode.getPrev());
        assertNull(removedNode.getNext());

        assertEquals(removedNode.getValue(), 0);

        assertNull(sut.getHead());
        assertEquals(sut.getHead(), sut.getTail());

        assertEquals(sut.getLength(), 0);
    }

    @Test
    public void test_removeFirst_twoNodes() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);
        sut.append(1);

        // when
        Node<Integer> removedNode = sut.removeFirst();

        // then
        assertNotNull(removedNode);
        assertNull(removedNode.getPrev());
        assertNull(removedNode.getNext());

        assertEquals(removedNode.getValue(), 0);

        assertNotNull(sut.getHead());
        assertEquals(sut.getHead().getValue(), 1);
        assertNull(sut.getHead().getPrev());
        assertNull(sut.getTail().getNext());

        assertEquals(sut.getHead(), sut.getTail());

        assertEquals(sut.getLength(), 1);
    }

    @Test
    public void test_get_underZeroIndex() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

        // when
        Node<Integer> foundNode = sut.get(-1);

        // then
        assertNull(foundNode);
    }

    @Test
    public void test_get_equalsLength() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);

        // when
        Node<Integer> foundNode = sut.get(sut.getLength());

        // then
        assertNull(foundNode);
    }

    @Test
    public void test_get_greaterThanLength() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);

        // when
        Node<Integer> foundNode = sut.get(sut.getLength() + 1);

        // then
        assertNull(foundNode);
    }

    @Test
    public void test_get_noNodes() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

        // when
        Node<Integer> foundNode = sut.get(0);

        // then
        assertNull(foundNode);
    }

    @Test
    public void test_get_oneNode() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);

        // when
        Node<Integer> foundNode = sut.get(0);

        // then
        assertNotNull(foundNode);
        assertEquals(foundNode.getValue(), 0);
    }

    @Test
    public void test_get_firstHalf() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);
        sut.append(1);
        sut.append(2);
        sut.append(3);
        sut.append(4);

        // when
        Node<Integer> foundNode = sut.get(1);

        // then
        assertNotNull(foundNode);
        assertEquals(foundNode.getValue(), 1);
    }

    @Test
    public void test_get_secondHalf() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);
        sut.append(1);
        sut.append(2);
        sut.append(3);
        sut.append(4);

        // when
        Node<Integer> foundNode = sut.get(3);

        // then
        assertNotNull(foundNode);
        assertEquals(foundNode.getValue(), 3);
    }
}