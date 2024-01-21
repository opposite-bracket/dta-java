package ca.ravelo.dta.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void test_Stack() {
        // when
        Stack<Integer> sut = new Stack<>();

        // then
        assertNull(sut.getTop());
        assertEquals(sut.getHeight(), 0);
    }

    @Test
    public void test_Stack_withArgument() {
        // when
        Stack<Integer> sut = new Stack<>(0);

        // then
        assertNotNull(sut.getTop());
        assertEquals(sut.getTop().getValue(), 0);
        assertEquals(sut.getHeight(), 1);
    }

    @Test
    public void test_push_noNodes() {
        // given
        Stack<Integer> sut = new Stack<>();

        // when
        sut.push(0);

        // then
        assertNull(sut.getTop().getNext());
        assertEquals(sut.getTop().getValue(), 0);
        assertEquals(sut.getHeight(), 1);

    }

    @Test
    public void test_push_oneNode() {
        // given
        Stack<Integer> sut = new Stack<>(0);

        // when
        sut.push(1);

        // then
        assertNotNull(sut.getTop().getNext());
        assertEquals(sut.getTop().getValue(), 1);
        assertEquals(sut.getHeight(), 2);
    }

}
