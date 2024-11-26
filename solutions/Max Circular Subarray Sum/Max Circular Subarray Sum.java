class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum1 = 0, sum2 = 0, total = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i];
            sum2 += arr[i];
            total += arr[i];

            if (sum2 > 0)
                sum2 = 0;
            else
                min = Math.min(min, sum2);

            if (sum1 < 0)
                sum1 = 0;
            else
                max = Math.max(max, sum1);
        }

        return Math.max(max, total - min);
    }
}