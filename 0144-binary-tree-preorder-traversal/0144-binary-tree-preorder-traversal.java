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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> t = new ArrayList<>();
        solve(root, t);
        return t;
    }

    void solve(TreeNode root, List<Integer> t) {
        if (root == null) {
            return;
        }

        t.add(root.val);
        solve(root.left, t);
        solve(root.right, t);
    }
}