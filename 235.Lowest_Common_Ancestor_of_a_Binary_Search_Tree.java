/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pList = nodeToRoot(root, p);
        ArrayList<TreeNode> qList = nodeToRoot(root, q);
        
        Collections.reverse(pList);
        Collections.reverse(qList);
        int size = Math.min(pList.size(),qList.size());
        TreeNode ans = null; 
        for(int i=0;i<size; i++)
        {
            if(pList.get(i).val == qList.get(i).val)
            {
                ans = pList.get(i);
            }
        }
        
        return ans;
    }
    
    private ArrayList<TreeNode> nodeToRoot(TreeNode root, TreeNode node)
    {
        if(root == null)
        {
            return new ArrayList<TreeNode>();
        }
        if(root == node)
        {
            ArrayList<TreeNode> ba = new ArrayList<>();
            ba.add(node);
            return ba;
        }
        
        ArrayList<TreeNode> la = nodeToRoot(root.left, node);
        if(la.size() > 0)
        {
            la.add(root);
            return la;
        }
        
        ArrayList<TreeNode> ra = nodeToRoot(root.right, node);
        if(ra.size() > 0)
        {
            ra.add(root);
            return ra;
        }
        
        return new ArrayList<TreeNode>();
    }
}
