import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        Queue<Character> q = new LinkedList<>();

        for (char c : t.toCharArray()) {
            q.offer(c);
        }

        while (!q.isEmpty()) {
            if (index == s.length()){
                break;
            }
            char p  = q.poll();
            if (p == s.charAt(index)){
                index++;
            }
        }
        return index == s.length();
    }
}