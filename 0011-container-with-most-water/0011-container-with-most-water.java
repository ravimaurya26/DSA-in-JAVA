class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j = height.length-1;
        int sum=0;
        int max=Integer.MIN_VALUE;
        while(i<j){
            if(height[i]<height[j]){
             sum =(j-i)*(height[i]);
             i++;
            }
            else{
            sum = (j-i)*(height[j]);
            j--;

            }
            max= Math.max(sum,max);
            sum=0;

        }
        return max;
    }
}