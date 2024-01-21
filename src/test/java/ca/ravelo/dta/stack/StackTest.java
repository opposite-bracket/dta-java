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

}
