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
        assertTrue(sut.insert(1));

        // then
        assertEquals(1, sut.getRoot().value);
    }

    @Test
    public void test_insert_duplicate() {
        // given
        BinarySearchTree sut = new BinarySearchTree();

        // when
        assertTrue(sut.insert(1));
        assertFalse(sut.insert(1));

        // then
        assertEquals(1, sut.getRoot().value);
        assertNull(sut.getRoot().left);
        assertNull(sut.getRoot().right);
    }

    @Test
    public void test_insert_insertToRight() {
        // given
        BinarySearchTree sut = new BinarySearchTree();

        // when
        assertTrue(sut.insert(0));
        assertTrue(sut.insert(1));

        // then
        assertEquals(0, sut.getRoot().value);
        assertEquals(1, sut.getRoot().right.value);
    }

    @Test
    public void test_insert_insertTwoToRight() {
        // given
        BinarySearchTree sut = new BinarySearchTree();

        // when
        assertTrue(sut.insert(1));
        assertTrue(sut.insert(3));
        assertTrue(sut.insert(5));

        // then
        assertEquals(1, sut.getRoot().value);
        assertEquals(3, sut.getRoot().right.value);
        assertEquals(5, sut.getRoot().right.right.value);
    }

    @Test
    public void test_insert_insertToLeft() {
        // given
        BinarySearchTree sut = new BinarySearchTree();

        // when
        assertTrue(sut.insert(1));
        assertTrue(sut.insert(0));

        // then
        assertEquals(1, sut.getRoot().value);
        assertEquals(0, sut.getRoot().left.value);
    }

    @Test
    public void test_insert_insertTwoToLeft() {
        // given
        BinarySearchTree sut = new BinarySearchTree();

        // when
        assertTrue(sut.insert(5));
        assertTrue(sut.insert(3));
        assertTrue(sut.insert(1));

        // then
        assertEquals(5, sut.getRoot().value);
        assertEquals(3, sut.getRoot().left.value);
        assertEquals(1, sut.getRoot().left.left.value);
    }

    @Test
    public void test_contains_itemFound() {
        // given
        BinarySearchTree sut = new BinarySearchTree();
        sut.insert(5);
        sut.insert(3);
        sut.insert(1);

        // when
        assertTrue(sut.contains(3));
    }

    @Test
    public void test_contains_itemNotFound() {
        // given
        BinarySearchTree sut = new BinarySearchTree();
        sut.insert(5);
        sut.insert(3);
        sut.insert(1);

        // when
        assertFalse(sut.contains(9));
    }

}