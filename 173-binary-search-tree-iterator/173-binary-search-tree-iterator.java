
class BSTIterator {
    
    private LinkedList<TreeNode> st = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        insertAllLeft(root, st);
    }
    
    public void insertAllLeft(TreeNode node, LinkedList<TreeNode> st) {
        while(node != null) {
            st.addFirst(node);
            node = node.left;
        }
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

