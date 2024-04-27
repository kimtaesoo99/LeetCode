class Solution {
    private static final int MAX = Integer.MAX_VALUE;

    public int findRotateSteps(String ring, String key) {
        Map<Pair<Integer, Integer>, Integer> bestSteps = new HashMap<>();
        return tryLock(0, 0, ring, key, MAX, bestSteps);
    }

    private int countSteps(int curr, int next, int ringLength) {
        int stepsBetween = Math.abs(curr - next);
        int stepsAround = ringLength - stepsBetween;
        return Math.min(stepsBetween, stepsAround);
    }

    public int tryLock(int ringIndex, int keyIndex, String ring, String key, int minSteps,
            Map<Pair<Integer, Integer>, Integer> bestSteps) {
        if (bestSteps.containsKey(new Pair<>(ringIndex, keyIndex))) {
            return bestSteps.get(new Pair<>(ringIndex, keyIndex));
        }

        if (keyIndex == key.length()) {
            return 0;
        }

        for (int charIndex = 0; charIndex < ring.length(); charIndex++) {
            if (ring.charAt(charIndex) == key.charAt(keyIndex)) {
                int totalSteps = countSteps(ringIndex, charIndex, ring.length()) + 1
                                            + tryLock(charIndex, keyIndex + 1, ring, key, MAX, bestSteps);
                minSteps = Math.min(minSteps, totalSteps);
                bestSteps.put(new Pair<>(ringIndex, keyIndex), minSteps);
            }
        }
        return minSteps;
    }
}