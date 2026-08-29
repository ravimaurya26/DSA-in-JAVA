class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int counter = 1;
        int max = 1;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i + 1] - nums[i] == 1) {
                counter++;
            } 
            else if (nums[i + 1] == nums[i]) {
                
            } 
            else {
                counter = 1;
            }

            max = Math.max(max, counter);
        }

        return max;
    }
}