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
    
    public int diameterOfBinaryTree(TreeNode node)
    {
        if(node==null)
            return 0;
        
        int lh = height(node.left);
        int rh = height(node.right);
        int op1 = lh + rh + 2;
        int ld = diameterOfBinaryTree(node.left);
        int rd = diameterOfBinaryTree(node.right);
        int ans = Math.max(op1, Math.max(ld, rd));
        return ans;
    }
    
    
    
    public static int height(TreeNode node)
    {
        if(node==null)
            return -1;
        
        int lh = height(node.left);
        int rh = height(node.right);
        int ans = Math.max(lh, rh) + 1;
        return ans;
    }
}
