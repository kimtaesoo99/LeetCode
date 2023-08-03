import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        HashMap<Character, String> phone = new HashMap<>();
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");

        backTrack(digits, 0, phone, new StringBuilder(), result);
        return result;
    }

    private static void backTrack(String digits, int index, HashMap<Character, String> phone, StringBuilder sb, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String now = phone.get(digits.charAt(index));
        for (int i = 0; i < now.length(); i++) {
            sb.append(now.charAt(i));
            backTrack(digits, index + 1, phone, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}