import java.util.Stack;

class Solution {

    public int minimumDeletions(String s) {
        int n = s.length();
        Stack<Character> charStack = new Stack<>();
        int deleteCount = 0;

        for (int i = 0; i < n; i++) {
            char now = s.charAt(i);

            if (!charStack.isEmpty() && charStack.peek() == 'b' && now == 'a') {
                charStack.pop();
                deleteCount++;
            } else {
                charStack.push(now);
            }
        }

        return deleteCount;
    }
}