class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        Arrays.sort(arr, (i, j) -> (i[0] - j[0]));
        List<int[]> ans = new ArrayList<>();
        int i = 0, n = arr.length;
        while (i < n) {
            int j = i + 1;
            while (j < n && arr[j][0] <= arr[i][1]) {
                arr[i][1] = Math.max(arr[i][1], arr[j][1]);
                j++;
            }
            ans.add(arr[i]);
            i = j;
        }
        return ans;
    }
}