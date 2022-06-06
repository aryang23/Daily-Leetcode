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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTreeHelper(nums, 0, nums.length-1);
    }
    
    public TreeNode buildTreeHelper(int[] nums, int lo, int hi) {
        if(lo > hi) {
            return null;
        }
        int mid = (lo+hi)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTreeHelper(nums, lo, mid-1);
        node.right = buildTreeHelper(nums, mid+1, hi);
        return node;
    }
}