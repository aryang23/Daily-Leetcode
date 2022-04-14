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
    public TreeNode searchBST(TreeNode root, int data) {
        if(root==null)
            return null;
        TreeNode curr = root;
        while(curr != null) {
            if(curr.val == data) {
                return curr;
            } else if(curr.val < data) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return null;
    }
}