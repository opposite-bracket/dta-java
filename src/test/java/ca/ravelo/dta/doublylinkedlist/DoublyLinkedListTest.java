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

    @Test
    public void test_set_noNodes() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

        // when
        boolean wasSet = sut.set(1, 0);

        // then
        assertFalse(wasSet);
    }

    @Test
    public void test_set_oneNode() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);

        // when
        boolean wasSet = sut.set(10, 0);

        // then
        assertTrue(wasSet);
        assertEquals(sut.getHead().getValue(), 10);
    }

    @Test
    public void test_set_twoNodes() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);
        sut.append(1);

        // when
        boolean wasSet = sut.set(10, 1);

        // then
        assertTrue(wasSet);
        assertEquals(sut.getTail().getValue(), 10);
    }

    @Test
    public void test_insert_indexLessThanZero() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

        // when
        boolean wasInserted = sut.insert(10, -1);

        // then
        assertFalse(wasInserted);

        assertEquals(sut.getLength(), 0);
    }

    @Test
    public void test_insert_greaterThanLength() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

        // when
        boolean wasInserted = sut.insert(10, sut.getLength() + 1);

        // then
        assertFalse(wasInserted);
        assertEquals(sut.getLength(), 0);
    }

    @Test
    public void test_insert_threeNodes_first() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);
        sut.append(1);
        sut.append(2);

        // when
        boolean wasInserted = sut.insert(10, 0);

        // then
        assertTrue(wasInserted);

        assertEquals(sut.getHead().getValue(), 10);

        assertEquals(sut.getHead().getNext().getValue(), 0);
        assertEquals(sut.getHead().getNext().getPrev(), sut.getHead());

        assertEquals(sut.getHead().getNext().getNext().getValue(), 1);
        assertEquals(sut.getTail().getValue(), 2);
        assertEquals(sut.getLength(), 4);
    }

    @Test
    public void test_insert_threeNodes_middle() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);
        sut.append(1);
        sut.append(2);

        // when
        boolean wasInserted = sut.insert(10, 1);

        // then
        assertTrue(wasInserted);
        assertEquals(sut.getHead().getValue(), 0);

        assertEquals(sut.getHead().getNext().getValue(), 10);
        assertEquals(sut.getHead().getNext().getPrev(), sut.getHead());

        assertEquals(sut.getHead().getNext().getNext().getValue(), 1);
        assertEquals(sut.getTail().getValue(), 2);
        assertEquals(sut.getLength(), 4);
    }

    @Test
    public void test_insert_threeNodes_last() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);
        sut.append(1);
        sut.append(2);

        // when
        boolean wasInserted = sut.insert(10, sut.getLength());

        // then
        assertTrue(wasInserted);
        assertEquals(sut.getHead().getValue(), 0);
        assertEquals(sut.getHead().getNext().getValue(), 1);
        assertEquals(sut.getHead().getNext().getNext().getValue(), 2);
        assertEquals(sut.getTail().getValue(), 10);
        assertEquals(sut.getLength(), 4);
    }

    @Test
    public void test_remove_indexLessThanZero() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

        // when
        Node<Integer> removedNode = sut.remove(-1);

        // then
        assertNull(removedNode);
    }

    @Test
    public void test_remove_equalToLength() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

        // when
        Node<Integer> removedNode = sut.remove(sut.getLength());

        // then
        assertNull(removedNode);
    }

    @Test
    public void test_remove_greaterThanLength() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

        // when
        Node<Integer> removedNode = sut.remove(sut.getLength() + 1);

        // then
        assertNull(removedNode);
    }

    @Test
    public void test_remove_threeNodes_first() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);
        sut.append(1);
        sut.append(2);

        // when
        Node<Integer> removedNode = sut.remove(0);

        // then
        assertNotNull(removedNode);
        assertNull(removedNode.getPrev());
        assertNull(removedNode.getNext());

        assertEquals(removedNode.getValue(), 0);

        assertNull(sut.getHead().getPrev());

        assertEquals(sut.getHead().getValue(), 1);
        assertEquals(sut.getTail().getValue(), 2);

        assertEquals(sut.getLength(), 2);
    }

    @Test
    public void test_remove_threeNodes_middle() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);
        sut.append(1);
        sut.append(2);

        // when
        Node<Integer> removedNode = sut.remove(1);

        // then
        assertNotNull(removedNode);
        assertNull(removedNode.getPrev());
        assertNull(removedNode.getNext());

        assertEquals(removedNode.getValue(), 1);

        assertEquals(sut.getHead().getValue(), 0);
        assertEquals(sut.getTail().getValue(), 2);

        assertEquals(sut.getHead().getNext(), sut.getTail());
        assertEquals(sut.getTail().getPrev(), sut.getHead());

        assertEquals(sut.getLength(), 2);
    }

    @Test
    public void test_remove_threeNodes_last() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>(0);
        sut.append(1);
        sut.append(2);

        // when
        Node<Integer> removedNode = sut.remove(2);

        // then
        assertNotNull(removedNode);
        assertNull(removedNode.getPrev());
        assertNull(removedNode.getNext());

        assertEquals(removedNode.getValue(), 2);

        assertEquals(sut.getHead().getValue(), 0);
        assertEquals(sut.getTail().getValue(), 1);

        assertEquals(sut.getLength(), 2);
    }

    @Test
    public void test_swapFirstLast_null() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

        // when
        sut.swapFirstLast();

        // then
        assertNull(sut.getHead());
        assertNull(sut.getTail());
    }

    @Test
    public void test_swapFirstLast_OneNode(){
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();
        sut.append(0);

        // when
        sut.swapFirstLast();

        // then
        assertNotNull(sut.getHead());
        assertNotNull(sut.getTail());
        assertEquals(0, sut.getHead().getValue());
        assertEquals(0, sut.getTail().getValue());
    }

    @Test
    public void test_swapFirstLast_TwoNodes(){
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();
        sut.append(0);
        sut.append(1);

        // when
        sut.swapFirstLast();

        // then
        assertNotNull(sut.getHead());
        assertNotNull(sut.getTail());
        assertEquals(1, sut.getHead().getValue());
        assertEquals(0, sut.getTail().getValue());
    }

    @Test
    public void test_swapFirstLast_MoreThanTwoNodes(){
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();
        sut.append(0);
        sut.append(1);
        sut.append(2);
        sut.append(3);

        // when
        sut.swapFirstLast();

        // then
        assertNotNull(sut.getHead());
        assertNotNull(sut.getTail());
        assertEquals(3, sut.getHead().getValue());
        assertEquals(0, sut.getTail().getValue());
    }

    @Test
    public void test_reverse_noItems() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();

        // when
        sut.reverse();

        // then
        assertNull(sut.getHead());
        assertNull(sut.getTail());
    }

    @Test
    public void test_reverse_OneItem() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();
        sut.append(0);

        // when
        sut.reverse();

        // then
        assertNotNull(sut.getHead());
        assertNotNull(sut.getTail());
        assertEquals(0, sut.getHead().getValue());
        assertEquals(0, sut.getTail().getValue());
    }

    @Test
    public void test_reverse_twoItems() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();
        sut.append(0);
        sut.append(1);

        // when
        sut.reverse();

        // then
        assertNotNull(sut.getHead());
        assertNotNull(sut.getTail());
        assertEquals(1, sut.getHead().getValue());
        assertEquals(0, sut.getHead().getNext().getValue());
        assertEquals(0, sut.getTail().getValue());
        assertEquals(1, sut.getTail().getPrev().getValue());
    }

    @Test
    public void test_reverse_moreThanTwoItems() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();
        sut.append(0);
        sut.append(1);
        sut.append(2);
        sut.append(3);

        // when
        sut.reverse();

        // then
        assertNotNull(sut.getHead());
        assertNotNull(sut.getTail());
        assertEquals(3, sut.getHead().getValue());
        assertEquals(2, sut.getHead().getNext().getValue());
        assertEquals(1, sut.getHead().getNext().getNext().getValue());
        assertEquals(0, sut.getHead().getNext().getNext().getNext().getValue());
        assertEquals(0, sut.getTail().getValue());
        assertEquals(1, sut.getTail().getPrev().getValue());
        assertEquals(2, sut.getTail().getPrev().getPrev().getValue());
        assertEquals(3, sut.getTail().getPrev().getPrev().getPrev().getValue());
    }

    @Test
    public void test_isPalindrome_null() {

    }

    @Test
    public void test_isPalindrome_true() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();
        sut.append(1);
        sut.append(2);
        sut.append(3);
        sut.append(2);
        sut.append(1);

        // when
        boolean isPalindrome = sut.isPalindrome();

        // then
        assertTrue(isPalindrome);
    }

    @Test
    public void test_isPalindrome_false() {
        // given
        DoublyLinkedList<Integer> sut = new DoublyLinkedList<>();
        sut.append(1);
        sut.append(2);
        sut.append(3);
        sut.append(4);
        sut.append(5);

        // when
        boolean isPalindrome = sut.isPalindrome();

        // then
        assertFalse(isPalindrome);
    }

}