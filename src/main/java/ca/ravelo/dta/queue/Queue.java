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
    public int hashCode() {
        return Objects.hash(first, last, length);
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
}
