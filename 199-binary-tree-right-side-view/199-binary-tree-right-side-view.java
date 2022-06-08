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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lv = new ArrayList<>();
        if(root == null) {
              return lv;
        }
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
      
        q.add(root);
      
        while(q.size() > 0 ) {
            int count = q.size();
            int ln = -1;
            while(count-- > 0) {
                //Remove
                TreeNode rem = q.remove();
                //Update at each value
                ln = rem.val;
                //Work

                //Add
                if(rem.left != null) {
                    q.add(rem.left);
                }
                if(rem.right != null) {
                    q.add(rem.right);
                }
             }
            lv.add(ln);
        }
      return lv;
    }
}