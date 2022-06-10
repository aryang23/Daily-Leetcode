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
    static int cam;
    public int minCameraCover(TreeNode root) {
        cam = 0;
        int sa = helper(root);
        if(sa == 0) {
            cam++;
        }
        return cam;
    }
    
    public int helper(TreeNode node) {
        if(node == null) {
            return 2;
        }
        
        int lci = helper(node.left);
        int rci = helper(node.right);
        
        if(lci==0 || rci==0) {
            //Any Child Needs Cam
            cam++;
            return 1;
        } else if(lci==1 || rci==1) {
            //Any child has camera
            //So, I am covered
            return 2;
        } else {
            return 0;
        }
    }
}