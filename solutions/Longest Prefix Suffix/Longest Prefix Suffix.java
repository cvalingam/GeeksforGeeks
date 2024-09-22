class Solution {
    int lps(String str) {
        int[] preArry = new int[str.length()];
        int j = 0;

        for (int i = 1; i < str.length(); i++) {

            while (j > 0 && str.charAt(i) != str.charAt(j))
                j = preArry[j - 1];

            if (str.charAt(i) == str.charAt(j))
                j++;

            preArry[i] = j;
        }
        return preArry[str.length() - 1];
    }
}