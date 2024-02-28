package ca.ravelo.dta.hashtable;

import java.util.ArrayList;
import java.util.List;

public class HashTable<T> {

    private int size;
    private Node<T>[] map;

    // O(1)
    public HashTable(int size) {
        this.size = size;
        this.map = new Node[size];
    }

    public int getSize() {
        return size;
    }

    public Node<T>[] getMap() {
        return map;
    }

    public int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23) % map.length;
        }
        return hash;
    }

    public void set(String key, T value) {
        int index = hash(key);
        Node<T> newNode = new Node<>(key, value);
        if (map[index] == null) {
            map[index] = newNode;
        } else {
            Node<T> curr = map[index];
            if (curr.getKey().equals(key)) {
                curr.setValue(value);
                return;
            }

            while (curr.getNext() != null) {
                if (curr.getKey().equals(key)) {
                    curr.setValue(value);
                    return;
                }
                curr = curr.getNext();
            }
            curr.setNext(newNode);
        }
    }

    public T get(String key) {
        int index = hash(key);
        Node curr = map[index];

        while(curr != null) {
            if (curr.getKey().equals(key)) {
                return (T) curr.getValue();
            }
            curr = curr.getNext();
        }

        return null;
    }

    public List<String> keys() {
        List<String> allKeys = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Node curr = map[i];
            while (curr != null) {
                allKeys.add(curr.getKey());
                curr = curr.getNext();
            }
        }

        return allKeys;
    }
}
