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
    public static class Pair {
        int lzzp;
        int rzzp;
        int mzzp;
        
        Pair() {
            
        }
        
        Pair(int lzzp, int rzzp, int mzzp) {
            this.lzzp = lzzp;
            this.rzzp = rzzp;
            this.mzzp = mzzp;
        }
    }
    public int longestZigZag(TreeNode root) {
        Pair ans = helper(root);
        return ans.mzzp;
    }
    
    public static Pair helper(TreeNode node) {
        if(node == null) {
            return new Pair(-1, -1, 0);
        }
        
        Pair lp = helper(node.left);
        Pair rp = helper(node.right);
        
        int lzzp = 1 + lp.rzzp;
        int rzzp = 1 + rp.lzzp;
        int mzzp = max(lp.mzzp, rp.mzzp, lzzp, rzzp);
        
        return new Pair(lzzp, rzzp, mzzp);
    }
    
    public static int max(int...arr) {
        int max = arr[0];
        
        for(int ele:arr) {
            if(ele > max) {
                max = ele;
            }
        }
        return max;
    }
}