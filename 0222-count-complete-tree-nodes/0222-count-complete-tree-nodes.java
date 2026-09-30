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
    public int countNodes(TreeNode root) {
        if(root==null)
        return 0;

        int leftheight = ghl(root);
        int rightheight = ghr(root);

        if(leftheight==rightheight)
        return(2<<(leftheight))-1;
        
        else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
        
    }

    public int ghl(TreeNode root){
        int count=0;
        while(root.left!=null){
        count++;
        root=root.left;
        }
        return count;

    }
     public int ghr(TreeNode root){
        int count=0;
        while(root.right!=null){
        count++;
        root=root.right;
        }
        return count;

    }
}