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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode d1, TreeNode d2) {
        
        ArrayList<TreeNode> arr1 = nodeToRootPath(root, d1.val);
		
        ArrayList<TreeNode> arr2 = nodeToRootPath(root, d2.val);
        if(arr1.size()==0 || arr2.size()==0)
        return new TreeNode(-1);
        
        Collections.reverse(arr1);
        Collections.reverse(arr2);
        
        int ans = 0;
        
        
        TreeNode nAns = null;
        int sz = Math.min(arr1.size(), arr2.size());
        for(int i=0; i<sz; i++) {
            if(arr1.get(i) == arr2.get(i)) {
                nAns = arr1.get(i);
            }
        }
        return nAns==null?new TreeNode(-1):nAns;
        
    }
    
    public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
    if (node.val == data) {
      ArrayList<TreeNode> path = new ArrayList<>();
      path.add(node);
      return path;
    }
    if(node.left != null) {
        ArrayList<TreeNode> ptc = nodeToRootPath(node.left, data);
          if (ptc.size() > 0) {
            ptc.add(node);
            return ptc;
          }
    }
    
    if(node.right != null) {
       ArrayList<TreeNode> ptc = nodeToRootPath(node.right, data);
      if (ptc.size() > 0) {
        ptc.add(node);
        return ptc;
      }
    }

    return new ArrayList<>();
  }
    
    
}