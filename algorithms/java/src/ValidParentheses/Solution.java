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

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') stack.add(s.charAt(i));
            if (!stack.empty()) {
                if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                    if (stack.peek() == getCounter(s.charAt(i))) {
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