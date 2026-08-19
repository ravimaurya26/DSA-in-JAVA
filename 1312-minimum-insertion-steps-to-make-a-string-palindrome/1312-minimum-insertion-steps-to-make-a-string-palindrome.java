class Solution {
    public int lcs(String s, String r){
        int m = s.length();
        int n = r.length();

        int [][] t = new int [m+1][n+1];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1)==r.charAt(j-1)){
                    t[i][j]= t[i-1][j-1] + 1;
                }
                else{
                    t[i][j]= Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }
    public int minInsertions(String s) {
        String r = "";

        for(int i= s.length()-1; i>=0; i--){
            r = r + s.charAt(i);
        }

        return s.length() - lcs(s,r);
        
    }
}