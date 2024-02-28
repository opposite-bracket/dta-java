package ca.ravelo.dta.hashtable;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    public void test_HashTable() {
        // when
        HashTable<Integer> sut = new HashTable<>(10);

        // then
        assertEquals(sut.getSize(), 10);
        assertNotNull(sut.getMap());
    }

    @Test
    public void test_hash() {
        // given
        String key = "sample-key";
        HashTable<Integer> sut = new HashTable<>(10);

        // when
        int index = sut.hash(key);

        // then
        assertEquals(8, index);
    }

    @Test
    public void test_getSet_nullIndex() {
        // given
        String key = "sample-key";
        int expected = 11;
        HashTable<Integer> sut = new HashTable<>(10);

        // when
        sut.set(key, expected);
        int actual = sut.get(key);

        // then
        assertEquals(actual, expected);
    }

    @Test
    public void test_set_sameIndexDifferentKeys() {
        // given
        String key1 = "sample-key9";
        String key2 = "sample-key10";
        int expected1 = 11;
        int expected2 = 15;
        HashTable<Integer> sut = new HashTable<>(10);

        // when
        sut.set(key1, expected1);
        sut.set(key2, expected2);
        int actual1 = sut.get(key1);
        int actual2 = sut.get(key2);

        // then
        assertEquals(actual1, expected1);
        assertEquals(actual2, expected2);
    }

    @Test
    public void test_set_sameIndexSameKey() {
        // given
        String key = "sample-key";
        int initVal = 11;
        int expected = 15;
        HashTable<Integer> sut = new HashTable<>(10);

        // when
        sut.set(key, initVal);
        sut.set(key, expected);
        int actual = sut.get(key);

        // then
        assertEquals(expected, actual);
    }



    @Test
    public void test_keys() {
        // given
        String key1 = "sample-key8";
        String key2 = "sample-key9";
        String key3 = "sample-key10";
        List<String> expected = Arrays.asList(key1, key2, key3);
        HashTable<Integer> sut = new HashTable<>(10);

        sut.set(key1, 1);
        sut.set(key2, 2);
        sut.set(key3, 3);

        // when
        List<String> actual = sut.keys();

        // then
        assertEquals(actual, expected);
    }
}