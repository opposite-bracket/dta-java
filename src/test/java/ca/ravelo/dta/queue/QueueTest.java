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


}