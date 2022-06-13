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
    //Wrong Approachh
    //Submission of Alternate Levels
    //Return the best
    
    //Correct Approach
    //Pair in which mzhe rob krna ya nhi
    //Include krte hue nd Excludde krte hue
    //Kya max topic generate hua h
    
    public static class Pair {
        int inc;
        int exc;
        
        Pair() {
            
        }
        
        Pair(int inc, int exc) {
            this.inc = inc;
            this.exc = exc;
        }
    }
    public int rob(TreeNode root) {
        Pair ans = solve(root);
        return Math.max(ans.inc, ans.exc);
    }
    
    public static Pair solve(TreeNode root) {
        if(root == null) {
            return new Pair(0, 0);
        }
        Pair lp = solve(root.left);
        Pair rp = solve(root.right);
        
        int incMax = lp.exc + rp.exc + root.val;
        int excMax = Math.max(lp.inc, lp.exc) + Math.max(rp.inc, rp.exc);
        
        return new Pair(incMax, excMax);
    }
}