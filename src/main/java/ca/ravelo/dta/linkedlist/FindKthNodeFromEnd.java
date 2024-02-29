package ca.ravelo.dta.linkedlist;

// Find Kth Node From End
//
public class FindKthNodeFromEnd {

    // Use a sliding window technique to traverse
    // the link list to find the kth node from the
    // end. Start by getting the hare to the pos
    // from then beginning, then use the sliding window
    // until the hare reaches the end.
    public static Node<?> kthNodeFromEnd(Node<?> head, int kth) {
        Node<?> t = head; // tortoise
        Node<?> h = head; // hare

        for (int i = 0; i < kth; i++) {
            if (h == null) {
                return null;
            }
            h = h.getNext();
        }

        while(h != null) {
            t = t.getNext();
            h = h.getNext();
        }

        return t;
    }
}
