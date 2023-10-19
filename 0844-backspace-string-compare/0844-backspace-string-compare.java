import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> result = new Stack();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                result.push(c);
            } else if (!result.empty()) {
                result.pop();
            }
        }
        return String.valueOf(result);
    }
}