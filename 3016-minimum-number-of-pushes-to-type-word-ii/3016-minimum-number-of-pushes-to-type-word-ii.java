class Solution {

    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> frequencyQueue = new PriorityQueue<>(
            (a, b) -> b - a
        );
        
        frequencyQueue.addAll(map.values());

        int result = 0;
        int index = 0;

        while (!frequencyQueue.isEmpty()) {
            result += (index / 8 + 1) * frequencyQueue.poll();
            index++;
        }

        return result;
    }
}