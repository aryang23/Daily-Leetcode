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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return buildTreeHelper(preorder, postorder, 0, n-1, 0, n-1);
    }
    
    public TreeNode buildTreeHelper(int[] preOrder, int[] postOrder, int prs, int pre, int pos, int poe) {
        if(prs > pre) {
            return null;
        }
        if(prs == pre) {
            return new TreeNode(preOrder[prs]);
        }
        
        int rootVal = preOrder[prs];
        TreeNode root = new TreeNode(rootVal);
        
        int leftRoot = preOrder[prs+1];
        int idx = -1;
        for(int i=pos; i<=poe; i++) {
            if(postOrder[i] == leftRoot) {
                idx = i;
                break;
            }
        }
        
        int colse = idx - pos + 1;
        
        root.left = buildTreeHelper(preOrder, postOrder, prs+1, prs+colse, pos, idx);
        root.right = buildTreeHelper(preOrder, postOrder, prs+colse+1, pre, idx+1, poe-1);
        return root;
    }
}