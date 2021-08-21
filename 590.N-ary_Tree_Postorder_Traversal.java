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
    public List<Integer> postorder(Node root) {
        
        List<Integer> list  = new ArrayList<>();
        if(root==null)
            return list;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(st.size()!=0)
        {
            Node remNode = st.pop();
            
            for(Node el:remNode.children)
            {
                st.add(el);
            }
            list.add(remNode.val);
        }
        Collections.reverse(list);
        return list;
    }
}
