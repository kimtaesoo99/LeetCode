import java.util.Stack;

/**
 *  ab 제거하면 -> x 포인트
 *  ba 제거하면 -> y 포인트
 *
 */

class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> q = new Stack<>();

        int result = 0;

        boolean flag = true;

        if (x > y){
            flag = false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (flag) {
                if (!q.isEmpty() && q.peek() == 'b' && s.charAt(i) == 'a') {
                    q.pop();
                    result += y;
                } else {
                    q.push(s.charAt(i));
                }
            } else {
                if (!q.isEmpty() && q.peek() == 'a' && s.charAt(i) == 'b') {
                    q.pop();
                    result += x;
                } else {
                    q.push(s.charAt(i));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()){
            sb.append(q.pop());
        }

        String remain = sb.reverse().toString();

        for (int i = 0; i < remain.length(); i++) {
            if (flag) {
                if (!q.isEmpty() && q.peek() == 'a' && remain.charAt(i) == 'b') {
                    q.pop();
                    result += x;
                } else {
                    q.push(remain.charAt(i));
                }
            } else {
                if (!q.isEmpty() && q.peek() == 'b' && remain.charAt(i) == 'a') {
                    q.pop();
                    result += y;
                } else {
                    q.push(remain.charAt(i));
                }
            }
        }

        return result;
    }
}