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
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead;
        fakeHead.next = head;
        ListNode curr = head;
        while(curr!=null)
        {
            if(curr.next!=null && curr.val==curr.next.val)
            {
                prev.next = curr.next;
            }
            else
                prev=curr;
            curr=curr.next;
        }
        return fakeHead.next;
        
    }
    
    public ListNode deleteDuplicates(ListNode head)
    {
        if(head==null || head.next==null)
            return head;
        
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr!=null)
        {
            while(curr!=null && curr.val==prev.val)
            {
                ListNode forw = curr.next;
                curr.next = null;
                curr = forw;
            }
            
            prev.next = curr;
            prev = curr;
            if(curr!=null)
                curr = curr.next;
        }
        return head;
    }
}