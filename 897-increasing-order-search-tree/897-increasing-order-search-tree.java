class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list=new ArrayList();
        inorder(root,list);
        
        TreeNode dummyRoot= new TreeNode(0);
        TreeNode current=dummyRoot;
        for(int v:list)
        {
            current=current.right=new TreeNode(v);
        }
        return dummyRoot.right;
    }
    private void inorder(TreeNode root,List<Integer> list)
    {
        if(root==null)
            return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}