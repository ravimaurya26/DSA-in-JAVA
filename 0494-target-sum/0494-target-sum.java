class Solution {
    public int Subset(int []arr,int si){
        int n= arr.length;
        int[][] t = new int [n+1][si+1];

          t[0][0] = 1;

          for (int i = 1; i <= n; i++) {
             if (arr[i - 1] == 0) {
                 t[i][0] = 2 * t[i - 1][0]; }
                  else {
                     t[i][0] = t[i - 1][0];
                      }
          } 
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=si; j++){
                if(arr[i-1]<=j)
                t[i][j]= t[i-1][j] + t[i-1][j-arr[i-1]];
                else{
                    t[i][j]= t[i-1][j];
                }
            }
        }
        return t[n][si];
    }
    public int findTargetSumWays(int[] arr, int target) {
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+= arr[i];
        }
        if(sum < target) return 0;
        if((sum+target)<0 || ((sum+target) % 2) != 0) return 0;
        int si= (sum + target)/2;
        
        return Subset(arr,si);
        
    }
}