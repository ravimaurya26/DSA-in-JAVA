/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxlevel=-1;
    int result = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return result;
        
    }

    public void dfs(TreeNode ro , int level){
        if(ro==null)
        return;
        
        if(ro.left==null && ro.right==null){
        if(level>maxlevel){
            maxlevel=level;
            result = ro.val;
        }
        }

        dfs(ro.left,level+1);
        dfs(ro.right,level+1);
    }
}