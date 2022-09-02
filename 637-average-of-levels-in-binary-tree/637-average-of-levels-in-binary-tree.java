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
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        List<Double> list = new ArrayList<>();
        if(root==null) {
            return list;
        }
        
        while(q.size() > 0) {
            // TreeNode rm = q.remove();
            long sum = 0;
            long count = 0;
            int size = q.size();
            while(size-- > 0) {
                TreeNode rm = q.remove();
                sum += rm.val;
                count++;
                
                if(rm.left != null) {
                    q.add(rm.left);
                }
                if(rm.right != null) {
                    q.add(rm.right);
                }
            }
            double avg = (double)(sum / count);
            double rem = (double)(sum % count)/count;
            list.add(avg+rem);
        }
        return list;
    }
}