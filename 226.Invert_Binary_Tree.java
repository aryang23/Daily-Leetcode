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
    public TreeNode invertTree1(TreeNode root) {
        
        if(root==null)
            return root;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        
        return root;
    }
    
    public TreeNode invertTree2(TreeNode root)
    {
        if(root==null)
            return root;
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(st.size()!=0)
        {
            TreeNode remNode = st.pop();
            
            TreeNode ln = remNode.left;
            remNode.left = remNode.right;
            remNode.right = ln;
            
            if(remNode.left!=null)
                st.push(remNode.left);
            
            if(remNode.right!=null)
                st.push(remNode.right);
        }
        return root;
    }
    
    public TreeNode invertTree(TreeNode root)
    {
        if(root == null)
            return root;
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()!=0)
        {
            TreeNode remNode = q.remove();
            
            TreeNode ln = remNode.left;
            remNode.left = remNode.right;
            remNode.right = ln;
            
            if(remNode.left!=null)
                q.add(remNode.left);
            
            if(remNode.right!=null)
                q.add(remNode.right);
        }
        return root;
    }
}
