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
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int lh = height(root.left);
        int rh = height(root.right);
        
        if(Math.abs(lh-rh)>1)
            return false;
        
        boolean ld = isBalanced(root.left);
        boolean rd = isBalanced(root.right);
        if(ld==true && rd==true)
            return true;
        return false;
    }
    
    public int height(TreeNode root)
    {
        if(root==null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        int ans = Math.max(lh, rh) + 1;
        return ans;
    }
}
