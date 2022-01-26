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
        int ans = size(root);
        return ans;
    }
    
    public int size(TreeNode root) {
        if(root==null)
            return 0;
        int size = 0;
        size += size(root.left);
        size += size(root.right);
        size += 1;
        return size;
    }
}