package ca.ravelo.dta.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    private List<Integer> heap;

    MinHeap() {
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        // keep heap private
        return new ArrayList<>(heap);
    }

    public int leftChild(int index) {
        return 2 * index + 1;
    }

    public int rightChild(int index) {
        return 2 * index + 2;
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public void swap(int i1, int i2) {
        int temp = heap.get(i1);
        heap.set(i1, heap.get(i2));
        heap.set(i2, temp);
    }

    public void insert(int v) {
        heap.add(v);
        int c = heap.size() - 1; // current
        while (c > 0 && heap.get(c) < heap.get(parent(c))) {
            swap(c, parent(c));
            c = parent(c);
        }
    }

    public Integer remove() {
        if (heap.size() == 0) {
            return null;
        }

        if (heap.size() == 1) {
            return heap.remove(0);
        }

        int maxVal = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return maxVal;
    }

    public void sinkDown(int i) {
        int mi = i;
        while(true) {
            int li = leftChild(i);
            int ri = rightChild(i);
            if (li < heap.size() && heap.get(li) < heap.get(mi)) {
                mi = li;
            }
            if (ri < heap.size() && heap.get(ri) < heap.get(mi)) {
                mi = ri;
            }
            if (mi != i) {
                swap(i, mi);
                i = mi;
            } else {
                return;
            }
        }
    }
}
