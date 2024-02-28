package ca.ravelo.dta.hashtable;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    public void test_Node() {
        // when
        Node<String> sut = new Node<>("k1", "v1");

        // then
        assertEquals(sut.getKey(), "k1");
        assertEquals(sut.getValue(), "v1");
        assertNull(sut.getNext());
    }

}
