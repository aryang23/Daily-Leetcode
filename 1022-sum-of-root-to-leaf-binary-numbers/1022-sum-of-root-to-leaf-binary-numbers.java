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
    private int totalSum = 0; 
    public int sumRootToLeaf(TreeNode root) {
        if(root == null)
            return 0;
        
        sumRootToLeafDFS(root, 0);
        return totalSum;
    }
    
    private void sumRootToLeafDFS(TreeNode root, int currSum)
    {
        if(root == null)
            return;
        
        currSum = currSum + root.val;
        
        if(root.left == null && root.right == null)
        {
            totalSum += currSum;
            return;
        }
        
        sumRootToLeafDFS(root.left, currSum * 2);
        sumRootToLeafDFS(root.right, currSum * 2);
    }
}