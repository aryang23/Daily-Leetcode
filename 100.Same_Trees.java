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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        int lp = length(p);
        int lq = length(q);
        if(lp!=lq)
            return false;
        
        return isSameTreeHelper(p, q);
    }
    
    public boolean isSameTreeHelper(TreeNode p, TreeNode q)
    {
        if(p==null || q==null)
            return p==q;
        if(p.val!=q.val)
            return false;
        
        return isSameTreeHelper(p.left, q.left) && isSameTreeHelper(p.right, q.right);
    }
    public int length(TreeNode root)
    {
        if(root==null)
            return 0;
        int lh = length(root.left);
        int rh = length(root.right);
        int ans = Math.max(lh, rh) + 1;
        return ans;
    }
}
