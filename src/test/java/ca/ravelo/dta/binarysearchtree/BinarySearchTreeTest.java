package ca.ravelo.dta.binarysearchtree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    public void test_BinarySearchTreeTest() {
        // when
        BinarySearchTree<Integer> sut = new BinarySearchTree<>();

        // then
        assertNull(sut.getRoot());
    }

}