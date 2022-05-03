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
    public static void insertAllLeft(TreeNode node, LinkedList<TreeNode> st) {
        while(node != null) {
            st.addFirst(node);
            node = node.left;
        }
    }

    public boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> st = new LinkedList<>();
        insertAllLeft(root, st);
        long prev = -(long)1e13;

        while(st.size() != 0) {
            TreeNode rNode = st.removeFirst();

            if(prev >= rNode.val) {
                return false;
            }
            prev = rNode.val;

            insertAllLeft(rNode.right, st);
        }
        return true;
    }
}