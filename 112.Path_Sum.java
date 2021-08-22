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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        
        if(root.left==null && root.right==null){
            if(targetSum - root.val==0){
                return true;
            }
            return false;
        }
        
        boolean lPath = hasPathSum(root.left, targetSum-root.val);
        if(lPath==true)
            return true;
        boolean rPath = hasPathSum(root.right, targetSum-root.val);
        if(rPath==true)
            return true;
        
        
        return false;
    }
    
}
