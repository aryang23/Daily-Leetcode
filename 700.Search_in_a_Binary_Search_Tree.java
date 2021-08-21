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
    public TreeNode searchBST(TreeNode root, int val) {
        
        if(root == null) return root;
        if(root.val == val){
            return root;
        }

        
        TreeNode nodeAns = null;
        
        if(val<root.val)
        {
            nodeAns = searchBST(root.left, val);
        }
        else
        {
            nodeAns = searchBST(root.right, val);
        }
        return nodeAns;
        
    }
}
