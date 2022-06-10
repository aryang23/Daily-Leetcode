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
    // HashMap<Integer, List<Integer>> map;
    static int sx;
    static int lx;

    
    public static class Pair implements Comparable<Pair>{
        int x;
        int y;
        TreeNode node;
        
        Pair(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
        
        public int compareTo(Pair o) {
            if(this.y != o.y) {
                return this.y - o.y;
            } else if(this.x != o.x) {
                return this.x - o.x;
            } else {
                return this.node.val - o.node.val;
            }
        }
    }
    public void helper(TreeNode node, int x) {
        if(node == null) {
            return;
        }
        sx = Math.min(sx, x);
        lx = Math.max(lx, x);
        
        helper(node.left, x-1);
        helper(node.right, x+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        sx = Integer.MAX_VALUE;
        lx = Integer.MIN_VALUE;
        
        helper(root, 0);
        
        int w = lx - sx + 1;
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0; i<w; i++) {
            ans.add(new ArrayList<>());
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(root, -sx, 0));
        
        while(pq.size() > 0) {
            //Remove
            Pair rem = pq.remove();
            
            //Work
            ans.get(rem.x).add(rem.node.val);
            
            //Add Children
            if(rem.node.left != null) {
                pq.add(new Pair(rem.node.left, rem.x - 1, rem.y + 1));
            } 
            if(rem.node.right != null){
                pq.add(new Pair(rem.node.right, rem.x + 1, rem.y + 1));
            }
        }
        return ans;
    }
}