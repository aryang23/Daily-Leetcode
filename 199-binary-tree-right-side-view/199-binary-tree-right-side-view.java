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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        helper(root, 0, arr);
        return arr;
    }
    public void helper(TreeNode node, int lev, List<Integer> arr) {
        if(node == null) {
            return;
        }
        if(lev == arr.size()) {
            arr.add(node.val);
        }
        helper(node.right, lev+1, arr);
        helper(node.left, lev+1, arr);
    }
}