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
    public static TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr) {
            node = node.right;
        }

        return node;
    }
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        long prev = -(long) 1e13;
        while(curr != null) {
            TreeNode left = curr.left;
            if(left == null) {
                if(prev >= curr.val) {
                    return false;
                }
                prev = curr.val;
                
                
                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if(rightMostNode.right == null) {
                    //Thread Creation Block
                    rightMostNode. right = curr;
                    curr = curr.left;
                } else {
                    //Thread Destroy Block
                    rightMostNode.right = null;
                    
                    if(prev >= curr.val) {
                        return false;
                    }
                    prev = curr.val;
                    
                    curr = curr.right;
                }
            }
        }
        return true;
    }
}