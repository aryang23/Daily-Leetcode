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
    private int ans;
    public int goodNodes(TreeNode root) {
        ans = 0;
        goodNodesHelper(root, Integer.MIN_VALUE);
        return ans;
    }
    private void goodNodesHelper(TreeNode root, int prevValue) {
        if(root==null) {
            return;
        }
        if(root.val >= prevValue) {
            ans++;
        }
        goodNodesHelper(root.left, Math.max(root.val, prevValue));
        goodNodesHelper(root.right, Math.max(root.val, prevValue));
    }
}