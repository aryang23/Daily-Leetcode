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
    public int maxDepth(TreeNode root) {
        int ht = 0;
        if(root==null)
            return ht;
        
        ht = Math.max(maxDepth(root.left), maxDepth(root.right));
        
        ht+=1;
        return ht;
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        int h1 = maxDepth(p);
        int h2 = maxDepth(q);
        
        if(h1!=h2)
            return false;
        if((p==null && q!=null) || (p!=null && q==null))
            return false;
        
        if(p==null && q==null)
            return true;
        
        if(p!=null && q!=null && p.val != q.val)
            return false;
        
        boolean sa = isSameTree(p.left, q.left);
        if(sa==false)
            return false;
        sa = isSameTree(p.right, q.right);
        if(sa==false)
            return false;
        return true;
    }
}