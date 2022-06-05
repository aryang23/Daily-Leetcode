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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        TreeNode root = buildTreeHelper(preorder, inorder, 0, n-1, 0, n-1);
        return root;
    }
    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        
        //Base Case
        if(ps > pe) {
            return null;
        }
        
        //Calculating RootVal, idx
        int rootVal = preorder[ps];
        int idx = -1;
         
        for(int i=is; i<=ie; i++) {
            if(inorder[i] == rootVal) {
                idx = i;
                break;
            }
        }
        
        //Calculating Colse: -
        int colse = idx - is;
        
        
        //2 Calls
        TreeNode leftTree = buildTreeHelper(preorder, inorder, ps+1, ps+colse, is, idx-1);
        TreeNode rightTree = buildTreeHelper(preorder, inorder, ps+colse+1, pe, idx+1, ie);
        
        TreeNode root = new TreeNode(rootVal, leftTree, rightTree);
        
        return root;
    }
}