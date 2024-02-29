package ca.ravelo.dta.linkedlist;

import java.util.HashSet;
import java.util.Set;

// Linked List Cycle
// https://leetcode.com/problems/linked-list-cycle/description/
public class CycleCheck<T> {

    public static boolean twoPointer_hasCycle(Node<?> head) {
        if (head == null || head.getNext() == null) {
            return false;
        }
        Node<?> t = head; // tortoise
        Node<?> h = head; // hare

        while (h != null && h.getNext() != null) {
            t = t.getNext();
            h = h.getNext().getNext();
            if (t == h) {
                return true;
            }
        }

        return false;
    }

    public static boolean visited_hasCycle(Node<?> head) {

        Set<Node<?>> v = new HashSet<>(); // visited
        Node<?> c = head; // current node
        while(c != null) {
            if (v.contains(c)) {
                return true;
            }
            v.add(c);
            c = c.getNext();
        }

        return false;
    }
}
