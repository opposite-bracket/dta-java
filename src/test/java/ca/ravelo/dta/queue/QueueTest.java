package ca.ravelo.dta.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    public void test_Queue() {
        // when
        Queue<Integer> sut = new Queue<>();

        // then
        assertNull(sut.getFirst());
        assertNull(sut.getLast());
        assertEquals(sut.getLength(), 0);
    }

    @Test
    public void test_Queue_withArgument() {
        // when
        Queue<Integer> sut = new Queue<>(0);

        // then
        assertNotNull(sut.getFirst());
        assertNotNull(sut.getLast());
        assertEquals(sut.getFirst(), sut.getLast());

        assertEquals(sut.getFirst().getValue(), 0);

        assertEquals(sut.getLength(), 1);
    }

    @Test
    public void test_enqueue_noNodes() {
        // given
        Queue<Integer> sut = new Queue<>();

        // when
        sut.enqueue(0);

        // then
        assertNotNull(sut.getFirst());
        assertNotNull(sut.getLast());
        assertEquals(sut.getFirst(), sut.getLast());

        assertEquals(sut.getLength(), 1);
    }

    @Test
    public void test_enqueue_oneNode() {
        // given
        Queue<Integer> sut = new Queue<>(0);

        // when
        sut.enqueue(1);

        // then
        assertNotNull(sut.getFirst());
        assertNotNull(sut.getLast());
        assertNotEquals(sut.getFirst(), sut.getLast());

        assertEquals(sut.getFirst().getValue(), 0);
        assertEquals(sut.getLast().getValue(), 1);

        assertEquals(sut.getLength(), 2);
    }

    @Test
    public void test_enqueue_twoNodes() {
        // given
        Queue<Integer> sut = new Queue<>(0);

        // when
        sut.enqueue(1);
        sut.enqueue(2);

        // then
        assertNotNull(sut.getFirst());
        assertNotNull(sut.getFirst().getNext());
        assertNotNull(sut.getLast());
        assertNotEquals(sut.getFirst(), sut.getLast());

        assertEquals(sut.getFirst().getValue(), 0);
        assertEquals(sut.getFirst().getNext().getValue(), 1);
        assertEquals(sut.getLast().getValue(), 2);

        assertEquals(sut.getLength(), 3);
    }

    @Test
    public void test_dequeue_noNodes() {
        // given
        Queue<Integer> sut = new Queue<>();

        // when
        Node<Integer> dequeued = sut.dequeue();

        // then
        assertNull(dequeued);
    }

    @Test
    public void test_dequeue_oneNode() {
        // given
        Queue<Integer> sut = new Queue<>(0);

        // when
        Node<Integer> dequeued = sut.dequeue();

        // then
        assertNotNull(dequeued);

        assertNull(sut.getFirst());
        assertNull(sut.getLast());

        assertEquals(dequeued.getValue(), 0);

        assertEquals(sut.getLength(), 0);
    }

    @Test
    public void test_dequeue_twoNodes() {
        // given
        Queue<Integer> sut = new Queue<>(0);
        sut.enqueue(1);

        // when
        Node<Integer> dequeued = sut.dequeue();

        // then
        assertNotNull(dequeued);

        assertNotNull(sut.getFirst());
        assertNotNull(sut.getLast());
        assertEquals(sut.getFirst(), sut.getLast());

        assertEquals(dequeued.getValue(), 0);
        assertEquals(sut.getFirst().getValue(), 1);
        assertEquals(sut.getLast().getValue(), 1);

        assertEquals(sut.getLength(), 1);
    }
}