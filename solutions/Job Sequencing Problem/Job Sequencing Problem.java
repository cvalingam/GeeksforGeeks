import java.util.*;

class Solution {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        int cnt = 0, sum = 0;
        boolean[] used = new boolean[n + 1];

        for (Job j : arr) {
            int d = j.deadline;
            while (d > 0) {
                if (!used[d]) {
                    used[d] = true;
                    cnt++;
                    sum += j.profit;
                    break;
                }
                d--;
            }
        }

        return new int[] { cnt, sum };
    }
}

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
