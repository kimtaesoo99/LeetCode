public class Solution {
    public String reversePrefix(String word, char ch) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        int index = 0;
        while (index < word.length()) {
            stack.push(word.charAt(index));
            if (word.charAt(index) == ch) {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                index++;
                while (index < word.length()) {
                    result.append(word.charAt(index));
                    index++;
                }
                return result.toString();
            }
            index++;
        }

        return word;
    }
}