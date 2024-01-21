package ca.ravelo.dta.binarysearchtree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    public void test_node() {
        // when
        Node<Integer> sut = new Node<>(0);

        // then
        assertEquals(sut.getValue(), 0);

        assertNull(sut.getLeft());
        assertNull(sut.getRight());
    }

    @Test
    public void test_setValue() {
        // given
        Node<Integer> sut = new Node<>(0);

        // when
        sut.setValue(1);

        // then
        assertEquals(sut.getValue(), 1);

        assertNull(sut.getLeft());
        assertNull(sut.getRight());
    }

    @Test
    public void test_setLeft() {
        // given
        Node<Integer> sut = new Node<>(0);
        Node<Integer> left = new Node<>(1);

        // when
        sut.setLeft(left);

        // then
        assertEquals(sut.getValue(), 0);

        assertEquals(sut.getLeft(), left);
        assertNull(sut.getRight());
    }

    @Test
    public void test_setRight() {
        // given
        Node<Integer> sut = new Node<>(0);
        Node<Integer> right = new Node<>(1);

        // when
        sut.setLeft(right);

        // then
        assertEquals(sut.getValue(), 0);

        assertEquals(sut.getLeft(), right);
        assertNull(sut.getRight());
    }

}