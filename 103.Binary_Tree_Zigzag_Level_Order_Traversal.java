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
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();
        if(root==null)
            return res;
        
        Queue<TreeNode> mq = new ArrayDeque<>();
        Queue<TreeNode> cq = new ArrayDeque<>();
        Stack<TreeNode> st = new Stack<>();
        int p = 1;
        mq.add(root);
        while(mq.size()>0 || st.size()>0)
        {
            if(p%2==0)
            {
                //Even Means Reverse
                while(st.size()>0)
                {
                    TreeNode el = st.pop();
                    TreeNode el2 = cq.remove();
                    smallAns.add(el.val);
                    if(el2.left!=null)
                        mq.add(el2.left);
                    
                    if(el2.right!=null)
                        mq.add(el2.right);
                }
            }
            else
            {
                while(mq.size()>0)
                {
                    TreeNode el = mq.remove();
                    smallAns.add(el.val);
                    if(el.left!=null)
                    {
                        cq.add(el.left);
                        st.push(el.left);
                    }
                    
                    if(el.right!=null)
                    {
                        cq.add(el.right);
                        st.push(el.right);
                    }
                }
            }
            // System.out.println();
            p++;
            res.add(smallAns);
            smallAns = new ArrayList<>();
        }
        return res;
    }
    
}
