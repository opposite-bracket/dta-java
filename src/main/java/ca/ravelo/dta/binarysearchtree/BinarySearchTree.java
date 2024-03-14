package ca.ravelo.dta.binarysearchtree;

public class BinarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node c = root; // current
        Node newNode = new Node(value);
        if (c == null) {
            root = newNode;
            return true;
        }

        while(c != null) {

            if (c.value == value) {
                return false;
            }

            // traverse
            if (value < c.value) {
                if (c.left == null) {
                    c.left = newNode;
                    return true;
                }
                c = c.left;
            } else {
                if (c.right == null) {
                    c.right = newNode;
                    return true;
                }
                c = c.right;
            }
        }

        return true;
    }

    public boolean contains(int value) {
        Node c = root; // current

        while(c != null) {
            if (c.value == value) {
                return true;
            }

            if (value < c.value) {
                c = c.left;
            } else {
                c = c.right;
            }
        }

        return false;
    }
}
