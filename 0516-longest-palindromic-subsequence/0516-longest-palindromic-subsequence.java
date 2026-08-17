class Solution {

    public int lcs(String s, String b) {

        int m = s.length();
        int n = b.length();

        int[][] t = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == b.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } 
                else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }

        return t[m][n];
    }

    public int longestPalindromeSubseq(String s) {

        String b = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            b = b + s.charAt(i);
        }

        return lcs(s, b);
    }
}