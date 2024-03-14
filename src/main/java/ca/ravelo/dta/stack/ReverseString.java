package ca.ravelo.dta.stack;

public class ReverseString {
    static public String reverseString(String value) {
        SortStack.Stack<Character> stack = new SortStack.Stack<>();
        String reversedString = "";

        for (char c : value.toCharArray()) {
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            reversedString += stack.pop();
        }

        return reversedString;

    }
}
