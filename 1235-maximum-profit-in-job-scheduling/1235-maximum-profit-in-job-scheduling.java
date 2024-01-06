import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; ++i) {
            jobs[i] = new Job(endTime[i], startTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            int pre = binary(jobs, i, jobs[i].startTime);
            dp[i + 1] = Math.max(dp[i], dp[pre] + jobs[i].profit);
        }

        return dp[n];
    }

    private int binary(Job[] jobs, int endIndex, int targetTime) {
        int left = 0;
        int right = endIndex;

        while (left < right) {
            int mid = (left + right) / 2;
            if (jobs[mid].endTime <= targetTime) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

class Job {
    int endTime;
    int startTime;
    int profit;

    public Job(int endTime, int startTime, int profit) {
        this.endTime = endTime;
        this.startTime = startTime;
        this.profit = profit;
    }
}