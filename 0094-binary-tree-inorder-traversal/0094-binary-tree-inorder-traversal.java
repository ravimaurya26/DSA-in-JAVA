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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> t = new ArrayList<>();
        solve(root,t);
        return t;
    }
    public void solve(TreeNode root, List<Integer> t){
        if(root==null){
        return;
        }
        solve(root.left,t);
        t.add(root.val);
        solve(root.right,t);
    }
}