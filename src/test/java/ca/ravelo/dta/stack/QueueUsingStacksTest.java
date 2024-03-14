package ca.ravelo.dta.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueUsingStacksTest {

    @Test
    public void test() {
        // given
        QueueUsingStacks sut = new QueueUsingStacks();

        // when
        sut.enqueue(1);
        sut.enqueue(2);
        sut.enqueue(3);

        // then
        assertEquals(1, sut.dequeue());
        assertEquals(2, sut.dequeue());
        assertEquals(3, sut.dequeue());
    }

}