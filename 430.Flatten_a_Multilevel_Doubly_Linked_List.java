/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    
    public Node flatten(Node head)
    {
        if(head==null)
            return head;
        
        Node p = head;
        while(p!=null)
        {
            //If No child, proceed
            if(p.child==null)
            {
                p = p.next;
                continue;
            }
            
            //Case 2: - Got child, Find the tail of the child and link it to the p.next
            Node temp = p.child;
            //Find tail of child
            while(temp.next!=null)
                temp = temp.next;
            
            //Connect tail with p.next, if it is not null
            temp.next = p.next;
            if(p.next!=null)
                p.next.prev = temp;
            
            //Conenct p with p.child and remove p.child
            p.next = p.child;
            p.child.prev = p;
            p.child = null;
        }
        return head;
    }
}
