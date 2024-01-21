package ca.ravelo.dta.stack;

import java.util.Objects;

public class Stack<T> {
    private Node<T> top;
    private int height;

    public Stack() {}

    public Stack(T value) {
        this.top = new Node<>(value);
        height = 1;
    }

    public Node<T> getTop() {
        return this.top;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack<?> stack = (Stack<?>) o;
        return height == stack.height && Objects.equals(top, stack.top);
    }

    @Override
    public int hashCode() {
        return Objects.hash(top, height);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "top=" + top +
                ", height=" + height +
                '}';
    }

    // pushes an item to the
    // top of the stack O(1)
    //
    // Edge cases:
    //  * Does not have any nodes
    //  * Has one or more nodes
    public void push(T value) {
        // create a new node
        Node<T> newNode = new Node<>(value);

        // if there are nodes
        if (0 < height) {
            // set newNode.next to point to the top
            newNode.setNext(top);
        }

        // set top to point to the new node
        top = newNode;

        // increase height
        height++;
    }
}
