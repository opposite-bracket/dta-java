package ca.ravelo.dta.doublylinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapPairsTest {

    @Test
    public void test_swapPairs_null(){
        // given
        SwapPairs sut = new SwapPairs();

        // when
        sut.swapPairs();
    }

    @Test
    public void test_swapPairs_OneItem(){
        // given
        // Input: 1
        SwapPairs sut = new SwapPairs(1);

        // when
        sut.swapPairs();

        // then
        // Output: 2 <-> 1 <-> 3
        assertEquals(1, sut.getHead().value);
    }

    @Test
    public void test_swapPairs_twoItems(){
        // given
        // Input: 1 <-> 2
        SwapPairs sut = new SwapPairs(1);
        sut.append(2);
        sut.append(3);

        // when
        sut.swapPairs();

        // then
        // Output: 2 <-> 1
        assertEquals(2, sut.getHead().value);
        assertEquals(1, sut.getHead().next.value);
    }

    @Test
    public void test_swapPairs_threeItems(){
        // given
        // Input: 1 <-> 2 <-> 3
        SwapPairs sut = new SwapPairs(1);
        sut.append(2);
        sut.append(3);

        // when
        sut.swapPairs();

        // then
        // Output: 2 <-> 1 <-> 3
        assertEquals(2, sut.getHead().value);
        assertEquals(1, sut.getHead().next.value);
        assertEquals(3, sut.getHead().next.next.value);
    }

    @Test
    public void test_swapPairs_fourItems(){
        // given
        // Input: 1 <-> 2 <-> 3 <-> 4
        SwapPairs sut = new SwapPairs(1);
        sut.append(2);
        sut.append(3);
        sut.append(4);

        // when
        sut.swapPairs();

        // then
        // Output: 2 <-> 1 <-> 4 <-> 3
        assertEquals(2, sut.getHead().value);
        assertEquals(1, sut.getHead().next.value);
        assertEquals(4, sut.getHead().next.next.value);
        assertEquals(3, sut.getHead().next.next.next.value);

    }

}