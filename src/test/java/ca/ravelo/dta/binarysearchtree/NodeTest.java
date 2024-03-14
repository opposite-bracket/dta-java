package ca.ravelo.dta.binarysearchtree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    public void test_node() {
        // when
        Node sut = new Node(0);

        // then
        assertEquals(sut.value, 0);

        assertNull(sut.left);
        assertNull(sut.right);
    }

    @Test
    public void test_setValue() {
        // given
        Node sut = new Node(0);

        // when
        sut.value = 1;

        // then
        assertEquals(sut.value, 1);

        assertNull(sut.left);
        assertNull(sut.right);
    }

    @Test
    public void test_setLeft() {
        // given
        Node sut = new Node(0);
        Node left = new Node(1);

        // when
        sut.left = left;

        // then
        assertEquals(sut.value, 0);

        assertEquals(sut.left, left);
        assertNull(sut.right);
    }

    @Test
    public void test_setRight() {
        // given
        Node sut = new Node(0);
        Node right = new Node(1);

        // when
        sut.right = right;

        // then
        assertEquals(sut.value, 0);

        assertEquals(sut.right, right);
        assertNull(sut.left);
    }

}