class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int l = 0;
        int r = k - 1;

        while (r < arr.length) {
            HashSet<Integer> hs = new HashSet<Integer>();
            for (int i = l; i <= r; i++)
                hs.add(arr[i]);
            l++;
            r++;
            al.add(hs.size());
        }

        return al;
    }
}
