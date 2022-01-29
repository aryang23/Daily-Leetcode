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
        boolean ans = hasPath(root, targetSum, 0);
        return ans;
    }
    
    public boolean hasPath(TreeNode root, int target, int sum) {
        if(root==null)
            return false;
        
        if(root.left==null && root.right==null){
            sum += root.val;
            // System.out.println(sum);
            if(sum==target)
                return true;
            return false;
        }
        
        
        boolean lans = hasPath(root.left, target, sum+root.val); 
        if(lans==true)
            return true;
        boolean rans = hasPath(root.right, target, sum+root.val);
        if(rans==true)
            return true;
        
        return false;
    }
}