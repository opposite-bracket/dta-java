package ca.ravelo.dta.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesesBalancedTest {

    @Test
    public void test() {
        assertTrue(ParenthesesBalanced.isBalancedParentheses("()"));
        assertTrue(ParenthesesBalanced.isBalancedParentheses("()()"));
        assertTrue(ParenthesesBalanced.isBalancedParentheses("(())"));
        assertTrue(ParenthesesBalanced.isBalancedParentheses("()()()"));
        assertTrue(ParenthesesBalanced.isBalancedParentheses("(()())"));
        assertFalse(ParenthesesBalanced.isBalancedParentheses(")()("));
        assertFalse(ParenthesesBalanced.isBalancedParentheses(")("));
        assertFalse(ParenthesesBalanced.isBalancedParentheses("(()"));
        assertFalse(ParenthesesBalanced.isBalancedParentheses("))"));
        assertFalse(ParenthesesBalanced.isBalancedParentheses("("));
        assertFalse(ParenthesesBalanced.isBalancedParentheses(")"));
    }

}