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

    @Test
    public void test_set_lessThanZero() {
        // given
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        boolean wasSet = sut.set(1, -1);

        // then
        assertFalse(wasSet);
    }

    @Test
    public void test_set_equalsToLength() {
        // given
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        boolean wasSet = sut.set(1, sut.getLength());

        // then
        assertFalse(wasSet);
    }

    @Test
    public void test_set_greaterThanLength() {
        // given
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        boolean wasSet = sut.set(1, sut.getLength() + 1);

        // then
        assertFalse(wasSet);
    }

    @Test
    public void test_set_noNodes() {
        // given
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        boolean wasSet = sut.set(1, 0);

        // then
        assertFalse(wasSet);
    }

    @Test
    public void test_set_oneNode() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);

        // when
        boolean wasSet = sut.set(10, 0);

        // then
        assertTrue(wasSet);
        assertEquals(sut.getHead().getValue(), 10);
    }

    @Test
    public void test_set_twoNodes() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);
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
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        boolean wasInserted = sut.insert(10, -1);

        // then
        assertFalse(wasInserted);
        assertEquals(sut.getLength(), 0);
    }

    @Test
    public void test_insert_greaterThanLength() {
        // given
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        boolean wasInserted = sut.insert(10, sut.getLength() + 1);

        // then
        assertFalse(wasInserted);
        assertEquals(sut.getLength(), 0);
    }

    @Test
    public void test_insert_threeNodes_first() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);
        sut.append(1);
        sut.append(2);

        // when
        boolean wasInserted = sut.insert(10, 0);

        // then
        assertTrue(wasInserted);
        assertEquals(sut.getHead().getValue(), 10);
        assertEquals(sut.getHead().getNext().getValue(), 0);
        assertEquals(sut.getHead().getNext().getNext().getValue(), 1);
        assertEquals(sut.getTail().getValue(), 2);
        assertEquals(sut.getLength(), 4);
    }

    @Test
    public void test_insert_threeNodes_middle() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);
        sut.append(1);
        sut.append(2);

        // when
        boolean wasInserted = sut.insert(10, 1);

        // then
        assertTrue(wasInserted);
        assertEquals(sut.getHead().getValue(), 0);
        assertEquals(sut.getHead().getNext().getValue(), 10);
        assertEquals(sut.getHead().getNext().getNext().getValue(), 1);
        assertEquals(sut.getTail().getValue(), 2);
        assertEquals(sut.getLength(), 4);
    }

    @Test
    public void test_insert_threeNodes_last() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);
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
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        Node<Integer> removedNode = sut.remove(-1);

        // then
        assertNull(removedNode);
    }

    @Test
    public void test_remove_equalToLength() {
        // given
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        Node<Integer> removedNode = sut.remove(sut.getLength());

        // then
        assertNull(removedNode);
    }

    @Test
    public void test_remove_greaterThanLength() {
        // given
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        Node<Integer> removedNode = sut.remove(sut.getLength() + 1);

        // then
        assertNull(removedNode);
    }

    @Test
    public void test_remove_threeNodes_first() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);
        sut.append(1);
        sut.append(2);

        // when
        Node<Integer> removedNode = sut.remove(0);

        // then
        assertNotNull(removedNode);
        assertEquals(removedNode.getValue(), 0);
        assertEquals(sut.getHead().getValue(), 1);
        assertEquals(sut.getTail().getValue(), 2);
        assertEquals(sut.getLength(), 2);
    }

    @Test
    public void test_remove_threeNodes_middle() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);
        sut.append(1);
        sut.append(2);

        // when
        Node<Integer> removedNode = sut.remove(1);

        // then
        assertNotNull(removedNode);
        assertEquals(removedNode.getValue(), 1);
        assertEquals(sut.getHead().getValue(), 0);
        assertEquals(sut.getTail().getValue(), 2);
        assertEquals(sut.getLength(), 2);
    }

    @Test
    public void test_remove_threeNodes_last() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);
        sut.append(1);
        sut.append(2);

        // when
        Node<Integer> removedNode = sut.remove(2);

        // then
        assertNotNull(removedNode);
        assertEquals(removedNode.getValue(), 2);
        assertEquals(sut.getHead().getValue(), 0);
        assertEquals(sut.getTail().getValue(), 1);
        assertEquals(sut.getLength(), 2);
    }

    @Test
    public void test_reverse_noNodes() {
        // given
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        sut.reverse();

        // then
        assertNull(sut.getHead());
        assertEquals(sut.getHead(), sut.getTail());
    }

    @Test
    public void test_reverse_oneNode() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);
        sut.append(1);

        // when
        sut.reverse();

        // then
        assertEquals(sut.getHead().getValue(), 1);
        assertEquals(sut.getTail().getValue(), 0);
    }

    @Test
    public void test_reverse_threeNodes() {
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);
        sut.append(1);
        sut.append(2);

        // when
        sut.reverse();

        // then
        assertEquals(sut.getHead().getValue(), 2);
        assertEquals(sut.getHead().getNext().getValue(), 1);
        assertEquals(sut.getTail().getValue(), 0);
    }

    @Test
    public void test_tortoiseHareFindMiddleNode_noItems(){
        // given
        LinkedList<Integer> sut = new LinkedList<>();

        // when
        Node<Integer> actual = sut.tortoiseHareFindMiddleNode();

        // then
        assertNull(actual);
    }

    @Test
    public void test_tortoiseHareFindMiddleNode_evenItems(){
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);
        sut.append(1);
        sut.append(2);
        sut.append(3);

        // when
        Node<Integer> actual = sut.tortoiseHareFindMiddleNode();

        // then
        assertEquals(2, actual.getValue());
    }

    @Test
    public void test_tortoiseHareFindMiddleNode_oddItems(){
        // given
        LinkedList<Integer> sut = new LinkedList<>(0);
        sut.append(1);
        sut.append(2);
        sut.append(3);
        sut.append(4);

        // when
        Node<Integer> actual = sut.tortoiseHareFindMiddleNode();

        // then
        assertEquals(2, actual.getValue());
    }

}