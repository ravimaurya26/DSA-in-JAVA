class Solution {
    public String lcs(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        int[][] t = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j - 1] + 1;
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        int i = m;
        int j = n;

        while (i > 0 && j > 0) {

            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } 
            else if (t[i - 1][j] > t[i][j - 1]) {
                i--;
            } 
            else {
                j--;
            }
        }

        return sb.reverse().toString();
    }

    public String shortestCommonSupersequence(String str1, String str2) {

        String lcs = lcs(str1, str2);

        StringBuilder ans = new StringBuilder();

        int i = 0;
        int j = 0;

        for (char ch : lcs.toCharArray()) {

            while (str1.charAt(i) != ch) {
                ans.append(str1.charAt(i));
                i++;
            }

            while (str2.charAt(j) != ch) {
                ans.append(str2.charAt(j));
                j++;
            }
            ans.append(ch);

            i++;
            j++;
        }

        while (i < str1.length()) {
            ans.append(str1.charAt(i));
            i++;
        }

        while (j < str2.length()) {
            ans.append(str2.charAt(j));
            j++;
        }

        return ans.toString();
    }
}