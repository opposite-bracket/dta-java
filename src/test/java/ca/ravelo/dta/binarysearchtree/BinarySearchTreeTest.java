package ca.ravelo.dta.binarysearchtree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    public void test_BinarySearchTreeTest() {
        // when
        BinarySearchTree sut = new BinarySearchTree();

        // then
        assertNull(sut.getRoot());
    }

    @Test
    public void test_insert_nullRoot() {
        // given
        BinarySearchTree sut = new BinarySearchTree();

        // when
        boolean inserted = sut.insert(1);

        // then
        assertTrue(inserted);
        assertEquals(1, sut.getRoot().value);
    }

    @Test
    public void test_insert_insertToRight() {
        // given
        BinarySearchTree sut = new BinarySearchTree();

        // when
        sut.insert(0);
        boolean inserted = sut.insert(1);

        // then
        assertTrue(inserted);
        assertEquals(0, sut.getRoot().value);
        assertEquals(1, sut.getRoot().right.value);
    }

    @Test
    public void test_insert_insertToLeft() {
        // given
        BinarySearchTree sut = new BinarySearchTree();

        // when
        sut.insert(1);
        boolean inserted = sut.insert(0);

        // then
        assertTrue(inserted);
        assertEquals(1, sut.getRoot().value);
        assertEquals(0, sut.getRoot().left.value);
    }

}