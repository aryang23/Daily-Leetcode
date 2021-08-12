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
        
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        List<Integer> smallAns = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0)
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                Node el = q.remove();
                smallAns.add(el.val);
                for(Node child:el.children)
                {
                    q.add(child);
                }
            }
            res.add(smallAns);
            smallAns = new ArrayList<>();
        }
        
        return res;
    }
}
