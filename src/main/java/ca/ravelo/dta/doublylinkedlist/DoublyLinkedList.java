package ca.ravelo.dta.doublylinkedlist;

import java.util.Objects;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    // O(1)
    public DoublyLinkedList() {
    }

    // O(1)
    public DoublyLinkedList(T value) {
        this.head = this.tail = new Node<>(value);
        this.length++;
    }


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
        DoublyLinkedList<?> that = (DoublyLinkedList<?>) o;
        return length == that.length && Objects.equals(head, that.head) && Objects.equals(tail, that.tail);
    }

    // O(1)
    @Override
    public int hashCode() {
        return Objects.hash(head, tail, length);
    }

    // O(1)
    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }
}
