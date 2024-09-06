class Solution {

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {
        int xorInd = 0;
        int xorVal = 0;
        for (int i = 1; i <= n; i++)
            xorInd ^= i;

        for (int val : arr)
            xorVal ^= val;

        return xorInd ^ xorVal;
    }
}