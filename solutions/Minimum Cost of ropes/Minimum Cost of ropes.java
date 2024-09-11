import java.util.*;

class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (long val : arr) {
            pq.add(val);
        }

        long totalCost = 0;

        while (pq.size() > 1) {
            long first = pq.poll();
            long second = pq.poll();

            long cost = first + second;
            totalCost += cost;

            pq.add(cost);
        }

        return totalCost;
    }
}