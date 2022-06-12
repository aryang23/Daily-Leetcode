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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        TreeNode curr = root;
        
        while(curr != null) {
            TreeNode ln = curr.left;
            
            if(ln == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rmn = getRightMostNode(ln, curr);
                
                if(rmn.right == null) {
                    //Left Subtree not visited
                    //Thread Creation Block
                    rmn.right = curr;
                    curr = curr.left;
                } else {
                    //Left Subtreee visited
                    //Thread Destroying Block
                    
                    rmn.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
    
    public TreeNode getRightMostNode(TreeNode ln, TreeNode curr) {
        TreeNode temp = ln;
        while(temp.right != null && temp.right != curr) {
            temp = temp.right;
        }
        return temp;
    }
}