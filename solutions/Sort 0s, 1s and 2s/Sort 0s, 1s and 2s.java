import java.util.*;

class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        int left = 0;
        int r = arr.size() - 1;
        int mid = 0;

        while (mid <= r) {
            if (arr.get(mid) == 2) {
                swap(arr, mid, r);
                r--;
            } else if (arr.get(mid) == 0) {
                swap(arr, mid, left);
                left++;
                mid++;
            } else {
                mid++;
            }
        }
    }

    private void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}