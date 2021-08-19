/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        copyList(head);
        copyRandoms(head);
        
        return extractList(head);
        
    }
    
    public static void copyList(Node head)
    {
        Node curr = head;
        while(curr!=null)
        {
            Node forw = curr.next;
            Node node = new Node(curr.val);
            
            curr.next = node;
            node.next = forw;
            
            curr = forw;
        }
    }
    
    public static void copyRandoms(Node head)
    {
        Node curr = head;
        while(curr!=null)
        {
            if(curr.random!=null)
            {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
    }
    
    public static Node extractList(Node head)
    {
        Node curr = head, dummy = new Node(-1), prev = dummy;
        while(curr!=null)
        {
            Node forw = curr.next.next;
            
            //Links
            prev.next = curr.next;
            curr.next = forw;
            
            //Move
            curr = forw;
            prev = prev.next;
        }
        return dummy.next;
    }
}
