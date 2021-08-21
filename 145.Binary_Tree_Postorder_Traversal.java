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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(st.size()!=0)
        {
            TreeNode remNode = st.pop();
            list.add(remNode.val);
            if(remNode.left!=null)
                st.push(remNode.left);
            if(remNode.right!=null)
                st.push(remNode.right);
        }
        Collections.reverse(list);
        return list;
            
        
    }
}
