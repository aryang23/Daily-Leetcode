class Solution {
    TreeNode big,small,prev;
    public void recoverTree(TreeNode root) {
        big=null;small=null;prev=null;
        rec(root);
        if(big!=null && small!=null){
            int temp=big.val;
            big.val=small.val;
            small.val=temp;     
        }
    }
    
    private void rec(TreeNode root){
        if(root==null) return ;
        rec(root.left);
        if(big!=null){
            if(small==null && root.val>big.val) big=root;
            else if(small!=null && root.val<small.val){
                small=root;
            }else if(small==null && root.val<prev.val){
                small=root;
            }
        }else{
            big=root;
        }
        prev=root;
        rec(root.right);
    }
}