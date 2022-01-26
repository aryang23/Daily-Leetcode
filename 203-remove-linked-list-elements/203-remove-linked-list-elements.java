/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements2(ListNode head, int val) {
        if(head==null)
            return head;
        ListNode prev=null, curr=head, fh = head;
        while(curr!=null)
        {
            if(curr.val==val)
            {
                ListNode cn = curr.next;
                curr.next = null;
                prev.next=curr.next;
                curr=cn;
            }
            prev = curr;
            curr = curr.next;
        }
        return fh;
    }
    
    public ListNode removeElements(ListNode head, int val) {
        ListNode fh = new ListNode(-1);
        ListNode prev = fh;
        fh.next = head;
        ListNode curr = head;
        ListNode dum = head;
        
        while(curr!=null)
        {
            if(curr.val==val)
                prev.next = curr.next;
            else
                prev = curr;
            
            curr = curr.next;
        }
        return fh.next;
    }
}