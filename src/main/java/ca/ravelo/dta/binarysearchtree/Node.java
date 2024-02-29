package ca.ravelo.dta.binarysearchtree;

import java.util.Objects;

public class Node<T> {

    private T value;
    private Node<T> left;
    private Node<T> right;

    // O(1)
    public Node(T value) {
        this.value = value;
    }

    // O(1)
    public T getValue() {
        return value;
    }

    // O(1)
    public void setValue(T value) {
        this.value = value;
    }

    // O(1)
    public Node<T> getLeft() {
        return left;
    }

    // O(1)
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    // O(1)
    public Node<T> getRight() {
        return right;
    }

    // O(1)
    public void setRight(Node<T> right) {
        this.right = right;
    }

    // O(1)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(value, node.value) && Objects.equals(left, node.left) && Objects.equals(right, node.right);
    }

    // O(1)
    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + (left == null ? null : left.value) +
                ", right=" + (right == null ? null : right.right) +
                '}';
    }
}
