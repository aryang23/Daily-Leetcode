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
    
        boolean nodeToRootPath_(TreeNode root, int data, ArrayList<TreeNode> ans) {

        if (root == null)
            return false;

        if (root.val == data) {
            ans.add(root);
            return true;
        }


        boolean res = nodeToRootPath_(root.left, data, ans) || nodeToRootPath_(root.right, data, ans);

        if (res)
            ans.add(root);
        return res;
    }
    
    public static ArrayList<TreeNode> nodeToRootPath(TreeNode node, int data) {
    // write your code here
    
    if(node==null) {
        ArrayList<TreeNode> ba = new ArrayList<>();
        return ba;
    }
    if(node.val == data) {
        ArrayList<TreeNode> ba = new ArrayList<>();
        ba.add(new TreeNode(data));
        return ba;
    }
    
    ArrayList<TreeNode> la = new ArrayList<>();
    la = nodeToRootPath(node.left, data);
    if(la.size() > 0) {
        la.add(node);
        return la;
    } 
    
    la = nodeToRootPath(node.right, data);
    if(la.size() > 0) {
        la.add(node);
        return la;
    }
    return la;
  }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<TreeNode> path = new ArrayList<>();
        nodeToRootPath_(root, target.val, path);
        // path = nodeToRootPath(root, target.val);
        
        TreeNode block = null;
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<path.size(); i++) {
            kDown(path.get(i), k-i, block, ans);
            block = path.get(i);
        }
        return ans;
    }
    
    public void kDown(TreeNode root, int k, TreeNode block, List<Integer> ans) {
        if(root==null || k < 0 || root==block) {
            return;
        }
        
        if(k==0) {
            ans.add(root.val);
            return;
        }
        
        kDown(root.left, k-1, block, ans);
        kDown(root.right, k-1, block, ans);
    }
}