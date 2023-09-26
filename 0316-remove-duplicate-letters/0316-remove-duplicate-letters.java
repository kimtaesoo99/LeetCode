import java.util.HashMap;
import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> inStack = new HashMap<>();
        HashMap<Character, Integer> count = new HashMap<>();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (inStack.containsKey(c)) {
                count.put(c, count.getOrDefault(c, 0) - 1);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && count.get(stack.peek()) >= 1) {
                inStack.remove(stack.peek());
                stack.pop();
            }

            stack.push(c);
            inStack.put(c, 1);
            count.put(c, count.getOrDefault(c, 0) - 1);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}