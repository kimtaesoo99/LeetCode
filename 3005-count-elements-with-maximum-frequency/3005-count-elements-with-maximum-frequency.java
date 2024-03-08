public class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = 0;
        for (int frequency : frequencies.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        int frequencyOfMaxFrequency = 0;
        for (int frequency : frequencies.values()) {
            if (frequency == maxFrequency) {
                frequencyOfMaxFrequency++;
            }
        }
        return frequencyOfMaxFrequency * maxFrequency;
    }
}