import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int result = 0;
        int left = 0;

        for (int right = people.length - 1; right >= 0; right--) {
            if (left > right) {
                break;
            }
            if (people[right] + people[left] <= limit) {
                left++;
            } 
            result++;
        }

        return result;
    }
}
