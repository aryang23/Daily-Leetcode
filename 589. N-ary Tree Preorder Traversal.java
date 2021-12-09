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
    public void rec(Node root, List<Integer> ans)
    {
        ans.add(root.val);
        for(Node child:root.children)
        {
            rec(child, ans);
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        rec(root, ans);
        return ans;
    }
}
