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
        List<String> res = new ArrayList<>();
        if(root==null)
            return res;
        binaryTreePathsHelper(root, "", res);
        return res;
    }
    public void binaryTreePathsHelper(TreeNode root, String path, List<String> res)
    {
        if(root.left==null && root.right==null)
        {
            path+=root.val;
            res.add(path);
            return;
        }
        if(root.left!=null)
        binaryTreePathsHelper(root.left, path+root.val+"->", res);
        if(root.right!=null)
        binaryTreePathsHelper(root.right, path+root.val+"->", res);
    }
}
