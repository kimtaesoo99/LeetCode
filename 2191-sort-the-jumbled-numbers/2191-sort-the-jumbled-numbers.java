import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Info[] infos = new Info[nums.length];

        for (int i = 0; i < infos.length; i++) {
            String now = String.valueOf(nums[i]);

            String result = Arrays.stream(now.split(""))
                    .map(j -> String.valueOf(mapping[Integer.parseInt(j)]))
                    .collect(Collectors.joining());

            infos[i] = new Info(Integer.parseInt(now), Integer.parseInt(result), i);
        }
        
        return Arrays.stream(infos)
                .sorted().mapToInt(i -> i.value)
                .toArray();
    }
}

class Info implements Comparable<Info> {

    int value;
    int cost;
    int index;

    public Info(int value, int cost, int index) {
        this.value = value;
        this.cost = cost;
        this.index = index;
    }

    @Override
    public int compareTo(Info o) {
        if (o.cost == this.cost) {
            return this.index - o.index;
        }
        return this.cost - o.cost;
    }
}