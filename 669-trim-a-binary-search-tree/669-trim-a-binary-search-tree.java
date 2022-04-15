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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return fun(root,low,high);
    }
    TreeNode fun(TreeNode a,int l,int h)
    {
        if(a==null)
            return null;
        TreeNode ans=new TreeNode();
        if(a.val>=l && a.val<=h) {
            ans=a;
            ans.left=fun(a.left,l,h);
            ans.right=fun(a.right,l,h);
        }
        else if(a.val<l) {
            return fun(a.right,l,h);
        }
        else if(a.val>h) {
            return fun(a.left,l,h);
        }
        return ans;
    }
}