class Solution {
    public int minRotations(String s) {
        int curr=0;
        int rotation=0;

        for(char ch : s.toCharArray()){
            int next = ch - '0';
            int diff = Math.abs(curr - next);
            rotation=rotation +Math.min(diff,10-diff);
            curr = next;
        }
        return rotation;
    }
}