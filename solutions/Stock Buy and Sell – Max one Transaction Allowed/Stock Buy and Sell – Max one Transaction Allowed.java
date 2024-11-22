class Solution {
    public int maximumProfit(int prices[]) {
        int minSofar = prices[0];
        int maxDiff = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minSofar) {
                minSofar = prices[i];
            }

            maxDiff = Math.max(maxDiff, prices[i] - minSofar);
        }
        
        return maxDiff;
    }
}