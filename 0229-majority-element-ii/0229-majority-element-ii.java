class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int ele1 = 0;
        int ele2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        

        for(int num : nums){
            if(num== ele1) {
                cnt1++;
            }
            else if(num == ele2){
                cnt2++;
            }
            else if(cnt1==0){
                ele1=num;
                cnt1 = 1; 
            }
              else if(cnt2==0){
                ele2=num;
                cnt2 = 1;
            }
            else{
                cnt1--;
                cnt2--;
            } 
        }
        int cnt3 = 0;
        int cnt4 = 0;
        for(int num : nums){
            if(num == ele1) cnt3++;
            else if(num == ele2) cnt4++;
        }

        List<Integer> ans = new ArrayList<>();
        if(cnt3 > n/3) ans.add(ele1);
        if(cnt4 > n/3) ans.add(ele2);
        return ans;
    }
}