/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() != 0) {
            int sz = q.size();
            List<Integer> sa = new ArrayList<>();
            while(sz > 0) {
                Node el = q.remove();
                sa.add(el.val);
                
                for(Node child:el.children) {
                    q.add(child);
                }
                sz--;
            }
            ans.add(sa);
        }
        return ans;
    }
}