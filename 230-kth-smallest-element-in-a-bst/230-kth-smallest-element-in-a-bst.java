class Solution {
    
    public static TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr) {
            node = node.right;
        }

        return node;
    }

    
    public int kthSmallest(TreeNode root, int k) {
        int rv = -1;
        TreeNode curr = root;
        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                if (--k == 0)
                    rv = curr.val;
                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) { // thread creation block
                    rightMostNode.right = curr; // thread is created

                    curr = curr.left;
                } else { // thread destroy block
                    rightMostNode.right = null; // thread is cut down

                    if (--k == 0)
                        rv = curr.val;

                    curr = curr.right;
                }
            }
        }

        return rv;
    }
}