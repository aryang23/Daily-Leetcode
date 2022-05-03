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
class BSTIterator {
    private LinkedList<TreeNode> st = new LinkedList<>();
    
    private void insertAllLeft(TreeNode root, LinkedList<TreeNode> st) {
        TreeNode node = root;
        while(node != null) {
            st.addFirst(node);
            node = node.left;
        }
    }
    public BSTIterator(TreeNode root) {
        insertAllLeft(root, st);
    }
    
    public int next() {
        TreeNode rn = st.removeFirst();
        insertAllLeft(rn.right, st);
        return rn.val;
    }
    
    public boolean hasNext() {
        return st.size() != 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */