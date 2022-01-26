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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> mq = new ArrayDeque<>();
        Queue<TreeNode> cq = new ArrayDeque<>();
        Stack<TreeNode> st = new Stack<>();
        int p = 1;
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        mq.add(root);
        
        while(mq.size()>0 || st.size()>0){
            List<Integer> sa = new ArrayList<>();
            if(p%2 == 0) {
                //Even means Reverse
                while(st.size() > 0) {
                    TreeNode el = st.pop();
                    TreeNode el2 = cq.remove();
                    // System.out.print(el.data + " ");
                    sa.add(el.val);
                    // for(TreeNode child:el2.children) {
                    //     mq.add(child);
                    // }
                    if(el2.left!=null)
                        mq.add(el2.left);
                    if(el2.right != null)
                        mq.add(el2.right);
                }
                // System.out.println();
            } else {
                while(mq.size() > 0) {
                    TreeNode el = mq.remove();
                    // System.out.print(el.data+" ");
                    sa.add(el.val);
                    // for(TreeNode child:el.children) {
                    //     cq.add(child);
                    //     st.push(child);
                    // }
                    if(el.left != null) {
                        cq.add(el.left);
                        st.push(el.left);
                    }
                    
                    if(el.right != null) {
                        cq.add(el.right);
                        st.push(el.right);
                    }
                }
                // System.out.println();
            }
            p++;
            ans.add(sa);
        }
        return ans;
    }
}