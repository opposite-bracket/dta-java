package ca.ravelo.dta.stack;

public class ParenthesesBalanced {

    static public boolean isBalancedParentheses(String string) {
        SortStack.Stack<Character> s = new SortStack.Stack();
        for (Character c : string.toCharArray()) {
            if (c == '(') {
                s.push(c);
            } else if (c == ')') {
                if (s.isEmpty() || s.pop() != '(') {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }

}
