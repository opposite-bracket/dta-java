package ca.ravelo.dta.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle/description/
class CycleCheckTest {

    // has cycle
    // [3,2,0,-4]
    //    |    |
    //    ------
    @Test
    public void test_scenario1(){
        // given
        Node<Integer> n1 = new Node<>(3);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(0);
        Node<Integer> n4 = new Node<>(-4);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n2);

        // when
        boolean twoPointer_hasCycle = CycleCheck.twoPointer_hasCycle(n1);
        boolean visited_hasCycle = CycleCheck.visited_hasCycle(n1);

        // then
        assertTrue(twoPointer_hasCycle);
        assertTrue(visited_hasCycle);
    }

    // has cycle
    // [1,2]
    //  | |
    //  ---
    @Test
    public void test_scenario2(){
        // given
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);

        n1.setNext(n2);
        n2.setNext(n1);

        // when
        boolean twoPointer_hasCycle = CycleCheck.twoPointer_hasCycle(n1);
        boolean visited_hasCycle = CycleCheck.visited_hasCycle(n1);

        // then
        assertTrue(twoPointer_hasCycle);
        assertTrue(visited_hasCycle);
    }

    // does not have cycle
    // [1]
    @Test
    public void test_scenario3(){
        // given
        Node<Integer> n1 = new Node<>(1);

        // when
        boolean twoPointer_hasCycle = CycleCheck.twoPointer_hasCycle(n1);
        boolean visited_hasCycle = CycleCheck.visited_hasCycle(n1);

        // then
        assertFalse(twoPointer_hasCycle);
        assertFalse(visited_hasCycle);
    }
}