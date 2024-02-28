package ca.ravelo.dta.linkedlist;

import java.util.Objects;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;

    // O(1)
    LinkedList(T value) {
        this.head = this.tail = new Node<>(value);
        this.length = 1;
    }

    // O(1)
    LinkedList() {}

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
        LinkedList<?> that = (LinkedList<?>) o;
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
        return "LinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }

    // Append adds a node to the
    // end of the LinkedList O(1)
    //
    // Edge cases:
    //  * Does not have any nodes
    //  * Has one or more nodes
    public void append(T value) {
        // create newNode
        Node<T> newNode = new Node<>(value);

        // if LinkedList is empty
        if (length == 0) {
            // set newNode to point to head and tail
            head = tail = newNode;
        } else {
            // set tail.next to point to newNode
            tail.setNext(newNode);
            // set tail to point to newNode
            tail = newNode;
        }

        // increase length
        length++;
    }


    // Prepend adds a node to the
    // beginning of the LinkedList O(1)
    //
    // Edge cases:
    //  * Does not have any nodes
    //  * Has one or more nodes
    public void prepend(T value) {
        // create newNode
        Node<T> newNode = new Node<>(value);

        // if LinkedList is empty
        if (length == 0) {
            // set newNode to point to head and tail
            head = tail = newNode;
        } else {
            // set newNode.next to point to head
            newNode.setNext(head);
            // set head to point to newNode
            head = newNode;
        }

        // increase length
        length++;
    }

    // RemoveLast disconnects the last
    // node from the LinkedList and returns
    // it O(n)
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

        // remove the last node from LinkedList
        tail = prev;
        tail.setNext(null);

        // decrease length
        length--;

        return curr;
    }

    // RemoveFirst disconnects the last
    // node from the LinkedList and returns
    // true on success O(1)
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
        // set current.next to point to null
        curr.setNext(null);

        // decrease length
        length--;

        return curr;
    }

    // Get retrieves the node found in the
    // given 0-based index O(n)
    //
    // Edge cases:
    //  * index is out of bounds (i < 0 || length <= i)
    //  * Does not have any nodes
    //  * Has one or more nodes
    public Node<T> get(int index) {
        // set current to head
        Node<T> curr = head;
        // index is out of bounds
        if (index < 0 || length <= index) {
            return null;
        }

        // navigate to the desired index
        for (int i = 0; i < index; i++) {
            // update current pointer
            curr = curr.getNext();
        }

        // return current
        return curr;
    }

    // Set updates the value of a node found in the
    // given 0-based index O(n)
    //
    // Edge cases:
    //  * index is out of bounds (i < 0 || length <= i)
    //  * Does not have any nodes
    //  * Has one or more nodes
    public boolean set(T value, int index) {
        // set current to point to node in index
        Node<T> curr = get(index);
        // if current is not null
        if (curr != null) {
            // update current value
            curr.setValue(value);
        }

        // return true if the value was updated
        return curr != null;
    }

    // Insert Creates a new node and places it
    // in between the given index and its
    // predecessor O(n)
    //
    // Edge cases:
    //  * index is out of bounds (i < 0 || length < i)
    //  * Does not have any nodes
    //  * Has one node
    //  * has more than one node
    public boolean insert(T value, int index) {
        // if the index is out of bounds
        if (index < 0 || length < index) {
            // return false
            return false;
        }

        // if the index is 0
        if (index == 0) {
            // prepend
            prepend(value);
            return true;
        }

        // if index equals the length append
        if (index == length) {
            // append
            append(value);
            return true;
        }

        // set previous to point to the predecessor
        Node<T> prev = get(index - 1);
        // set next to prev.next
        Node<T> next = prev.getNext();
        // set previous to newNode
        prev.setNext(new Node<>(value));
        // set newNode to point to next
        prev.getNext().setNext(next);
        // increase length
        length++;

        return true;
    }

    // Remove disassociate a node from the
    // LinkList O(n)
    //
    // Edge cases:
    //  * index is out of bounds (i < 0 || length < i)
    //  * Does not have any nodes
    //  * Has one node
    //  * has more than one node
    public Node<T> remove(int index) {
        // if the index is out of bounds
        if (index < 0 || length <= index) {
            // return false
            return null;
        }

        // if the index is 0
        if (index == 0) {
            // removeFirst
            return removeFirst();
        }

        // if index equals the length append
        if (index == (length - 1)) {
            // removeLast
            return removeLast();
        }

        // set previous to point to the predecessor node
        Node<T> prev = get(index - 1);
        // set current to point to the node to remove
        Node<T> curr = prev.getNext();
        // set previous.next to the next successor node
        prev.setNext(curr.getNext());
        // set current.next to point to null to remove it
        curr.setNext(null);
        // decrease length
        length--;

        return curr;
    }

    // Reverse shifts the order
    // of a LinkList O(n)
    //
    // Edge cases:
    //  * Does not have any nodes
    //  * Has one or more nodes
    public void reverse() {

        // if length is 0
        if (length == 0) {
            // do nothing
            return;
        }

        // set previous to null
        Node<T> prev = null;
        // set current and next to head
        Node<T> current = head;
        Node<T> next = head;

        // flip head to tails
        head = tail;
        // set tails to point to current
        // (which must be head)
        tail = current;

        // loop until next is null
        while(next != null) {
            // move next to point to the following node
            next = current.getNext();
            // flip current to point backwards
            current.setNext(prev);
            // move previous to the current node
            prev = current;
            // move current to current.next
            current = next;
        }
    }

    // O(log n)
    public Node<T> tortoiseHareFindMiddleNode() {
        Node<T> tortoise = head;
        Node<T> hare = head;

        if (tortoise == null) {
            return tortoise;
        }

        while(hare != null && hare.getNext() != null) {
            tortoise = tortoise.getNext();
            hare = hare.getNext().getNext();
        }

        return tortoise;
    }
}
