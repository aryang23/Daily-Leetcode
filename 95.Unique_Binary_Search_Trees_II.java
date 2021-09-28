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
    
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp = new ArrayList[n+1][n+1];
        return generateTrees(1, n, dp);
        // return generateTrees2(1, n);
    }
    
    public List<TreeNode> generateTrees(int si, int ei, List<TreeNode>[][] dp)
    {
        List<TreeNode> myAns = new ArrayList<>();
        if (si >= ei) {
            TreeNode root = (si == ei ? new TreeNode(si) : null);
            myAns.add(root);
            return myAns;
        }
        
        if (dp[si][ei] != null)
            return dp[si][ei];
        
        for (int cut = si; cut <= ei; cut++)
        {
            List<TreeNode> leftList = generateTrees(si, cut - 1, dp);
            List<TreeNode> rightList = generateTrees(cut + 1, ei, dp);
            
            generateAllBST(leftList, rightList, myAns, cut);
        }
        
        return dp[si][ei] = myAns;
    }
    
    public List<TreeNode> generateTrees2(int si, int ei) {
        List<TreeNode> myAns = new ArrayList<>();
        if (si >= ei) {
            TreeNode root = (si == ei ? new TreeNode(si) : null);
            myAns.add(root);
            return myAns;
        }

        for (int cut = si; cut <= ei; cut++) {
            List<TreeNode> leftList = generateTrees2(si, cut - 1);
            List<TreeNode> rightList = generateTrees2(cut + 1, ei);

            generateAllBST(leftList, rightList, myAns, cut);
        }

        return myAns;
    }
    
    public void generateAllBST(List<TreeNode> leftList, List<TreeNode> rightList, List<TreeNode> ans, int num)     {
        for (TreeNode ln : leftList) {
            for (TreeNode rn : rightList) {
                TreeNode root = new TreeNode(num);
                root.left = ln;
                root.right = rn;
                ans.add(root);
            }
        }
    }
}
