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
    public void rec2(Node node, List<Integer> ans)
    {
        for(Node child:node.children)
        {
            rec(child, ans);
        }
        ans.add(node.val);
    }
    public List<Integer> postorder2(Node root) {
        
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        rec(root, ans);
        return ans;
    }
    
    public void rec(Node node, List<Integer> ans) {
        for(Node child:node.children) {
            rec(child, ans);
        }
        ans.add(node.val);
    }
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        rec(root, ans);
        return ans;
    }
}