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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return buildTreeHelper(postorder, inorder, 0, n-1, 0, n-1);
    }
    
    public TreeNode buildTreeHelper(int[] postorder, int[] inorder, int ps, int pe, int is, int ie) {
        
        //Base Case
        if(ps > pe) {
            return null;
        }
        
        //Calculating RootVal, idx
        int rootVal = postorder[pe];
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
        TreeNode leftTree = buildTreeHelper(postorder, inorder, ps, ps+colse-1, is, idx-1);
        TreeNode rightTree = buildTreeHelper(postorder, inorder, ps+colse, pe-1, idx+1, ie);
        
        TreeNode root = new TreeNode(rootVal, leftTree, rightTree);
        
        return root;
    }
}