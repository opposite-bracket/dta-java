package ca.ravelo.dta.linkedlist;

import java.util.Objects;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;

    // O(1)
    LinkedList(T value) {
        this.head = this.tail = new Node<>(value);
        this.length = 1;
    }

    // O(1)
    LinkedList() {}

    // O(1)
    public Node<T> getHead() {
        return head;
    }

    // O(1)
    public Node<T> getTail() {
        return tail;
    }

    // O(1)
    public int getLength() {
        return length;
    }

    // O(1)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList<?> that = (LinkedList<?>) o;
        return length == that.length && Objects.equals(head, that.head) && Objects.equals(tail, that.tail);
    }

    // O(1)
    @Override
    public int hashCode() {
        return Objects.hash(head, tail, length);
    }

    // Append adds a node to the
    // end of the LinkedList O(1)
    //
    // Edge cases:
    //  * Does not have any nodes
    //  * Has one or more nodes
    public void append(T value) {
        // create newNode
        Node<T> newNode = new Node<>(value);

        // if LinkedList is empty
        if (length == 0) {
            // set newNode to point to head and tail
            head = tail = newNode;
        } else {
            // set tail.next to point to newNode
            tail.setNext(newNode);
            // set tail to point to newNode
            tail = newNode;
        }

        // increase length
        length++;
    }
}
