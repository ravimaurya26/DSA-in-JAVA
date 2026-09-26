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
    public boolean isSymmetric(TreeNode root) {
    return root==null || dfs(root.left,root.right);
        
    }

    private boolean dfs(TreeNode a , TreeNode b){  // a is left and b is right for traversing
        if(a==null || b==null)
        return a==b;

        if(a.val!=b.val)
        return false;

        return dfs(a.left,b.right) && dfs(a.right,b.left);
    }
}