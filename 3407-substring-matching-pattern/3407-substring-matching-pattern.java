class Solution {
    public boolean hasMatch(String s, String p) {
        
        String[] parts = p.split("\\*", -1);
        
        String left = parts[0];
        String right = parts[1];
        
        int start = s.indexOf(left);
        
        if (start == -1) {
            return false;
        }
        
        int end = s.indexOf(right, start + left.length());
        
        return end != -1;
    }
}