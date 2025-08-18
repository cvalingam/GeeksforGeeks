class Solution {
    public int hIndex(int[] citations) {
        int maxCitation = 0;
        for (int citation : citations)
            maxCitation = Math.max(maxCitation, citation);

        int[] count = new int[maxCitation + 2];
        for (int citation : citations) {
            count[0]++;
            count[citation + 1]--;
        }

        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] >= i)
                return i;
        }

        return 0;
    }
}