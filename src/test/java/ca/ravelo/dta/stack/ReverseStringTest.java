package ca.ravelo.dta.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {
    @Test
    public void test() {
        // given
        String word = "hello";
        String expected = "olleh";

        // when
        String actual = ReverseString.reverseString(word);

        // then
        assertEquals(expected, actual);
    }
}