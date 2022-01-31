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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        path(root, ans, "");
        return ans;
    }
    
    public void path(TreeNode root, List<String> ans, String sa) {
        if(root==null)
            return;
        if(root.left==null && root.right==null) {
            sa+=root.val;
            ans.add(sa);
            return;
        }
        
        path(root.left, ans, sa+root.val+"->");
        path(root.right, ans, sa+root.val+"->");
    }
}