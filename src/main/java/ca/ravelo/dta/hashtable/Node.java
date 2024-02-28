package ca.ravelo.dta.hashtable;

import java.util.Objects;

public class Node<T> {

    private String key;
    private T value;
    private Node<T> next;

    // O(1)
    public Node(String key, T value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    // O(1)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(key, node.key) && Objects.equals(value, node.value) && Objects.equals(next, node.next);
    }

    // O(1)
    @Override
    public int hashCode() {
        return Objects.hash(key, value, next);
    }

    // O(1)
    @Override
    public String toString() {
        return "Node{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", next=" + (next == null ? null : next.value) +
                '}';
    }
}
