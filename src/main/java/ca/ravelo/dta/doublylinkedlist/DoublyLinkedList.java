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

    // Append adds a node to the
    // end of the DoubleLinkedList O(1)
    //
    // Edge cases
    //
    // Edge cases:
    //  * Does not have any nodes
    //  * Has one or more nodes
    public void append(T value) {
        // create new node
        Node<T> newNode = new Node<>(value);

        // if there are no nodes
        if (length == 0) {
            // set head and tail to it
            head = tail = newNode;
        } else {
            // set tail.next to point to newNode
            tail.setNext(newNode);
            // set newNode.prev to point to tail
            newNode.setPrev(tail);
            // set tail to the new node
            tail = newNode;
        }

        // set tail to point to node
        length++;
    }

    // Prepend adds a node to the
    // beginning of the DoublyLinkedList O(1)
    //
    // Edge cases:
    //  * Does not have any nodes
    //  * Has one or more nodes
    public void prepend(T value) {
        // create newNode
        Node<T> newNode = new Node<>(value);

        // if there are no nodes
        if (length == 0) {
            // set newNode to point to head and tail
            head = tail = newNode;
        } else {
            // set newNode.next to point to head
            newNode.setNext(head);
            // set head.next to point to newNode
            head.setPrev(newNode);
            // set head to point to newNode
            head = newNode;
        }

        // increase length
        length++;
    }

    // RemoveLast disconnects the last
    // node from the DoublyLinkedList
    // and returns it O(n)
    //
    // Edge cases:
    //  * Does not have any nodes
    //  * Has one or more nodes
    public Node<T> removeLast() {
        // set previous and current to point to the tail
        Node<T> prev = head, curr = head;
        // if length is 0
        if (length == 0) {
            // return current (which must be null)
            return curr;
        }

        // if there is one
        if (length == 1) {
            // set head and tail to null
            head = tail = null;
            length--;
            return curr;
        }

        // otherwise, navigate until current.next is null
        while (curr.getNext() != null) {
            // set before to point current
            prev = curr;
            // set current to current.next
            curr = curr.getNext();
        }

        // remove the last node
        tail = prev;
        tail.setNext(null);
        curr.setPrev(null);

        // decrease length
        length--;

        return curr;
    }

    // RemoveFirst disconnects the last
    // node from the DoublyLinkedList
    // and returns true on success O(1)
    //
    // Edge cases:
    //  * Does not have any nodes
    //  * Has one or more nodes
    public Node<T> removeFirst() {
        // set current to point to head
        Node<T> curr = head;

        // if length is 0
        if (length == 0) {
            // return current (must be null)
            return curr;
        } else if (length == 1) {
            // set head and tail to null
            head = tail = null;
            // decrease length
            length--;
            // return current (must be only item)
            return curr;
        }

        // set head to point to current.next
        head = curr.getNext();
        // set head.prev to point to null
        head.setPrev(null);
        // set current.next to point to null
        curr.setNext(null);

        // decrease length
        length--;

        return curr;
    }
}
