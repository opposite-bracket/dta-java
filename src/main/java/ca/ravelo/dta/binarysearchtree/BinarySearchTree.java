package ca.ravelo.dta.binarysearchtree;

import java.util.Objects;

public class BinarySearchTree<T> {
    private Node<T> root;

    // O(1)
    public BinarySearchTree() {}

    // O(1)
    public Node<T> getRoot() {
        return root;
    }

    // O(1)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinarySearchTree<?> that = (BinarySearchTree<?>) o;
        return Objects.equals(root, that.root);
    }

    // O(1)
    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
