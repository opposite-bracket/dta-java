package ca.ravelo.dta.doublylinkedlist;

import java.util.Objects;

public class Node<T> {
    private T value;
    private Node<T> prev;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(value, node.value) && Objects.equals(prev, node.prev) && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, prev, next);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", prev=" + (prev == null ? null : prev.value) +
                ", next=" + (next == null ? null : next.value) +
                '}';
    }

}
