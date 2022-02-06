package ValidParentheses;

import java.util.Stack;

class Solution {
    public char getCounter(char c) {
        return switch (c) {
            case '(' -> ')';
            case '[' -> ']';
            case '{' -> '}';
            case ')' -> '(';
            case ']' -> '[';
            case '}' -> '{';
            default -> throw new IllegalArgumentException();
        };
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') stack.add(c);
            if (!stack.empty()) {
                if (c == ')' || c == ']' || c == '}') {
                    if (stack.peek() == getCounter(c)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }

        return stack.empty();
    }
}