package ca.ravelo.dta.queue;

import java.util.Objects;

public class Queue<T> {

    private Node<T> first;
    private Node<T> last;
    private int length;

    // O(1)
    public Queue(T value) {
        this.first = this.last = new Node<>(value);
        length = 1;
    }

    // O(1)
    public Queue() {
    }

    // O(1)
    public Node<T> getFirst() {
        return first;
    }

    // O(1)
    public Node<T> getLast() {
        return last;
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
        Queue<?> queue = (Queue<?>) o;
        return length == queue.length && Objects.equals(first, queue.first) && Objects.equals(last, queue.last);
    }

    // O(1)
    @Override
    public String toString() {
        return "Queue{" +
                "first=" + first +
                ", last=" + last +
                ", length=" + length +
                '}';
    }

    // enqueue Adds a node as the
    // end (last) of the queue O(1)
    //
    // Edge cases:
    //  * Does not have any nodes
    //  * Has one or more nodes
    public void enqueue(T value) {
        // create a new node
        Node<T> newNode = new Node<>(value);

        // if there are no items
        if (length == 0) {
            // assign the node to the first and last
            first = last = newNode;
        } else {
            // Set last.next to point to newNode
            last.setNext(newNode);

            // Set last to point to newNode
            last = newNode;
        }

        // increase length
        length++;
    }

    // dequeue removes a node from the
    // beginning (first) of the queue O(1)
    //
    // Edge cases:
    //  * Does not have any nodes
    //  * Has one or more nodes
    public Node<T> dequeue() {
        // Set current to point to the first node
        Node<T> curr = first;

        // if there are no nodes
        if (length == 0) {
            // return current which is null
            return curr;
        }

        // if there is one node
        if (length == 1) {
            // set both first and last to null
            first = last = null;
        }

        // if it's more than one
        if (1 < length) {
            // set first to point to first.next
            first = first.getNext();

            // set current.next to null
            curr.setNext(null);
        }

        // decrease length
        length--;

        // return current
        return curr;
    }
}
