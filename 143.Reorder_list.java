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
    public void reorderList(ListNode head) {
        ListNode mid = midNode(head);
        ListNode nhead = mid.next;
        mid.next = null;
        nhead = reverse(nhead);
        
        ListNode c1 = head, c2 = nhead;
        while(c1!=null && c2!=null)
        {
            ListNode f1 = c1.next, f2 = c2.next;
            
            c1.next = c2;
            c2.next = f1;
            
            c1 = f1;
            c2 = f2;
        }
        
    }
    
    public ListNode midNode(ListNode head)
    {
        if(head==null || head.next==null)
        return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
    
        return slow;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        
        while(curr!=null)
        {
            ListNode currKaNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currKaNext;
        }
        return prev;
    }
}
