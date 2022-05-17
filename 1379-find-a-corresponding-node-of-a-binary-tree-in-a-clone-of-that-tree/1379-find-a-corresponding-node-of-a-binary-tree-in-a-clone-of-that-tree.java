class Solution {
    TreeNode ans;

    public void inorder(TreeNode c,TreeNode target) {
        if (c != null) {
            inorder(c.left, target);
            if (c.val == target.val) {
                ans = c;
            }
            inorder(c.right, target);
        }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        inorder(cloned,target);
        return ans;
    }
}