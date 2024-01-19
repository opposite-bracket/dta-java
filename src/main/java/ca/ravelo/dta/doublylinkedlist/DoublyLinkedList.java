package ca.ravelo.dta.doublylinkedlist;

import java.util.Objects;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    // O(1)
    public DoublyLinkedList() {
    }

    // O(1)
    public DoublyLinkedList(T value) {
        this.head = this.tail = new Node<>(value);
        this.length++;
    }


    // O(1)
    public Node<T> getHead() {
        return head;
    }

    // O(1)
    public Node<T> getTail() {
        return tail;
    }

    // O(1)
    public int getLength() {
        return length;
    }

    // O(1)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoublyLinkedList<?> that = (DoublyLinkedList<?>) o;
        return length == that.length && Objects.equals(head, that.head) && Objects.equals(tail, that.tail);
    }

    // O(1)
    @Override
    public int hashCode() {
        return Objects.hash(head, tail, length);
    }

    // O(1)
    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }

    // Append adds a node to the
    // end of the DoubleLinkedList O(1)
    //
    // Edge cases
    //
    // Edge cases:
    //  * Does not have any nodes
    //  * Has one or more nodes
    public void append(T value) {
        // create new node
        Node<T> newNode = new Node<>(value);

        // if there are no nodes
        if (length == 0) {
            // set head and tail to it
            head = tail = newNode;
        } else {
            // set tail.next to point to newNode
            tail.setNext(newNode);
            // set newNode.prev to point to tail
            newNode.setPrev(tail);
            // set tail to the new node
            tail = newNode;
        }

        // set tail to point to node
        length++;
    }

    // Prepend adds a node to the
    // beginning of the DoublyLinkedList O(1)
    //
    // Edge cases:
    //  * Does not have any nodes
    //  * Has one or more nodes
    public void prepend(T value) {
        // create newNode
        Node<T> newNode = new Node<>(value);

        // if there are no nodes
        if (length == 0) {
            // set newNode to point to head and tail
            head = tail = newNode;
        } else {
            // set newNode.next to point to head
            newNode.setNext(head);
            // set head.next to point to newNode
            head.setPrev(newNode);
            // set head to point to newNode
            head = newNode;
        }

        // increase length
        length++;
    }

    // RemoveLast disconnects the last
    // node from the DoublyLinkedList
    // and returns it O(n)
    //
    // Edge cases:
    //  * Does not have any nodes
    //  * Has one or more nodes
    public Node<T> removeLast() {
        // set previous and current to point to the tail
        Node<T> prev = head, curr = head;
        // if length is 0
        if (length == 0) {
            // return current (which must be null)
            return curr;
        }

        // if there is one
        if (length == 1) {
            // set head and tail to null
            head = tail = null;
            length--;
            return curr;
        }

        // otherwise, navigate until current.next is null
        while (curr.getNext() != null) {
            // set before to point current
            prev = curr;
            // set current to current.next
            curr = curr.getNext();
        }

        // remove the last node
        tail = prev;
        tail.setNext(null);
        curr.setPrev(null);

        // decrease length
        length--;

        return curr;
    }

    // RemoveFirst disconnects the last
    // node from the DoublyLinkedList
    // and returns true on success O(1)
    //
    // Edge cases:
    //  * Does not have any nodes
    //  * Has one or more nodes
    public Node<T> removeFirst() {
        // set current to point to head
        Node<T> curr = head;

        // if length is 0
        if (length == 0) {
            // return current (must be null)
            return curr;
        } else if (length == 1) {
            // set head and tail to null
            head = tail = null;
            // decrease length
            length--;
            // return current (must be only item)
            return curr;
        }

        // set head to point to current.next
        head = curr.getNext();
        // set head.prev to point to null
        head.setPrev(null);
        // set current.next to point to null
        curr.setNext(null);

        // decrease length
        length--;

        return curr;
    }

    // Get retrieves the node found in the
    // given 0-based index O(log n)
    //
    // Edge cases:
    //  * index is out of bounds (i < 0 || length <= i)
    //  * Does not have any nodes
    //  * Has one
    //  * Has more than one node
    //  * navigate forwards if the node is in the first
    //    half, otherwise, walk backwards
    public Node<T> get(int index) {
        // set current to head
        Node<T> curr = this.head;

        // index is out of bounds
        if (index < 0 || length <= index) {
            return null;
        }

        // if index is on the first half
        if (index < length / 2) {
            // navigate forward until node is found
            for (int i = 0; i < index; i++) {
                curr = curr.getNext();
            }
        } else {
            // set current to point to tail
            curr = this.tail;

            // navigate backwards until node is found
            for (int i = length - 1; i > index; i--) {
                curr = curr.getPrev();
            }
        }

        return curr;
    }

    // Get retrieves the node found in the
    // given 0-based index O(log n)
    //
    // Edge cases:
    //  * index is out of bounds (i < 0 || length <= i)
    //  * Does not have any nodes
    //  * Has one or more nodes
    public boolean set(T value, int index) {
        Node<T> curr = get(index);
        boolean isFound = curr != null;
        if (isFound) curr.setValue(value);

        return isFound;
    }

    // Insert, creates a new node and places it in between
    // the given index and its predecessor O(log n)
    //
    // Edge cases:
    //  * index is out of bounds (index < 0 || length < index)
    //  * Does not have any nodes
    //  * has nodes:
    //  *   append
    //  *   prepend
    //  *   insert in the middle
    public boolean insert(T value, int index){
        // return false if out of bounds
        if (index < 0 || length < index) return false;

        // prepend if index is 0
        if (index == 0) {
            prepend(value);
            return true;
        }

        // prepend if index equals length
        if (index == length) {
            append(value);
            return true;
        }

        // create newNode
        Node<T> newNode = new Node<>(value);

        // get the predecessor (current.prev) to the node
        // in the given index (current)
        Node<T> curr = get(index);

        // set newNode.next to point to the node in the
        // given index (current)
        newNode.setNext(curr);

        // set newNode.prev to point to the
        // predecessor (current.prev) to the node
        // in the given position (curr)
        newNode.setPrev(curr.getPrev());

        // set predecessor (current.prev.next)
        // to point to the new node
        curr.getPrev().setNext(newNode);

        // set the pushed node to point to newNode
        curr.setPrev(newNode);

        // set pre

        length++;

        return true;
    }

    // Removes an item from a given position.
    //
    // Edge cases:
    //  * index is out of bounds (index < 0 || length < index)
    //  * Does not have any nodes
    //  * has nodes:
    //  *   removeLast
    //  *   removeFirst
    //  *   remove in the middle
    public Node<T> remove(int index) {
        // do nothing when out of bounds
        if (index < 0 || length <= index) {
            return null;
        }

        // if index points to the first item
        if (index == 0) {
            // remove first
            return removeFirst();
        }

        // if index points to the last item
        if ( index == length - 1 ) {
            // remove last
            return removeLast();
        }

        // get node to be removed
        Node<T> curr = get(index);

        // set the predecessor (curr.prev)
        // to the next item to the one
        // being removed (current.next)
        curr.getPrev().setNext(curr.getNext());

        // set the next item to the one
        // being removed (next.prev)
        // to point to the predecessor (prev)
        curr.getNext().setPrev(curr.getPrev());

        // disconnect node to remove (current
        curr.setPrev(null);
        curr.setNext(null);

        length--;

        return curr;
    }
}
