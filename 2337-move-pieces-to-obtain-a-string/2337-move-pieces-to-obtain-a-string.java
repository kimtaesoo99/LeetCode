class Solution {
    public boolean canChange(String start, String target) {
        Queue<Pair<Character, Integer>> startQueue =
            new LinkedList<>(), targetQueue = new LinkedList<>();

        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != '_') {
                startQueue.add(new Pair<>(start.charAt(i), i));
            }
            if (target.charAt(i) != '_') {
                targetQueue.add(new Pair<>(target.charAt(i), i));
            }
        }

        if (startQueue.size() != targetQueue.size()) return false;

        while (!startQueue.isEmpty()) {
            Pair<Character, Integer> startPair = startQueue.poll();
            Pair<Character, Integer> targetPair = targetQueue.poll();

            char startChar = startPair.getKey();
            int startIndex = startPair.getValue();
            char targetChar = targetPair.getKey();
            int targetIndex = targetPair.getValue();

            if (startChar != targetChar || (startChar == 'L' && startIndex < targetIndex) || (startChar == 'R' && startIndex > targetIndex)) {
                return false;
            }
        }

        return true;
    }
}