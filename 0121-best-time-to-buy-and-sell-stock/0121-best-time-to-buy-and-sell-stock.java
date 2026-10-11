class Solution {
    public int maxProfit(int[] prices) {
     int buy  = Integer.MAX_VALUE;
     int profit = 0;

     for(int i=0; i<prices.length;i++){
         if(buy<prices[i]){
          int x=prices[i]-buy;
          profit=Math.max(profit,x);
         }
         else{
            buy=prices[i];
         }

        } 
        return profit;
     
     
    }
}