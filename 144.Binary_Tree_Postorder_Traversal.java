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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(st.size()!=0)
        {
            TreeNode remNode = st.pop();
            list.add(remNode.val);
            if(remNode.right!=null)
                st.push(remNode.right);
            if(remNode.left!=null)
                st.push(remNode.left);
            
        }
        return list;
    }
}
