package ca.ravelo.dta.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortStackTest {

    @Test
    public void test_sortStack_scenario1() {
        // EXPECTED OUTPUT:
        // ----------------
        // Before sorting: (top to bottom)
        // 4
        // 1
        // 5
        // 2
        // 3
        SortStack.Stack<Integer> stack = new SortStack.Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(1);
        stack.push(4);

        SortStack.sortStack(stack);

        // After sorting:
        // 1
        // 2
        // 3
        // 4
        // 5
        assertEquals(1, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(5, stack.pop());
    }

    @Test
    public void test_sortStack_scenario2() {
        // EXPECTED OUTPUT:
        // ----------------
        // Before sorting:
        // 3
        // 1
        // 4
        // 2
        SortStack.Stack<Integer> stack = new SortStack.Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        SortStack.sortStack(stack);

        // After sorting:
        // 1
        // 2
        // 3
        // 4
        // 5
        assertEquals(1, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(4, stack.pop());
    }

}