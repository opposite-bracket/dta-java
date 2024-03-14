package ca.ravelo.dta.stack;

public class QueueUsingStacks {
    private SortStack.Stack<Integer> stack1;
    private SortStack.Stack<Integer> stack2;

    public QueueUsingStacks() {
        stack1 = new SortStack.Stack<>();
        stack2 = new SortStack.Stack<>();
    }

    // WRITE THE ENQUEUE METHOD HERE //
    public void enqueue(int value) {

        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
    ///////////////////////////////////

    // WRITE THE DEENQUEUE METHOD HERE //
    public Integer dequeue() {
        return stack1.pop();
    }
    ///////////////////////////////////

    public int peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
