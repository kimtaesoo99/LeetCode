import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        long sum = skill[0] + skill[skill.length - 1];

        long result = 0;

        int right = skill.length - 1;
        for (int i = 0; i < skill.length / 2; i++) {
            if (skill[i] + skill[right] != sum) {
                result = -1;
                break;
            } else {
                result += skill[i] * skill[right--];
            }
        }

        return result;
    }
}
