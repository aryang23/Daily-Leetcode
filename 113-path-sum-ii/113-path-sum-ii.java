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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sa = new ArrayList<>();
        hasPath(root, targetSum, 0, sa, res);
        return res;
    }
    
    public void hasPath(TreeNode root, int target, int sum, List<Integer> sa, List<List<Integer>> res) {
        if(root==null)
            return;
        
        if(root.left==null && root.right==null) {
            sum += root.val;
            if(sum==target) {
                sa.add(root.val);
                List<Integer> ba = new ArrayList<>(sa);
                res.add(ba);
                sa.remove(sa.size()-1);
            }
            return;
        }
        sa.add(root.val);
        hasPath(root.left, target, sum + root.val, sa, res);
        hasPath(root.right, target, sum + root.val, sa, res);
        sa.remove(sa.size()-1);
    }
}