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
    public boolean isPalindrome2(ListNode head) {
        int size = 0;
        ListNode l1 = head;
        while(l1!=null)
        {
            l1=l1.next;
            size++;
        }
        
        int left = 0, right = size-1;
        while(left<=right)
        {
            ListNode ln = getNodeAt(head, left++);
            ListNode rn = getNodeAt(head, right--);
            
            if(ln.val!=rn.val)
                return false;
        }
        return true;
    }
    
    public ListNode getNodeAt(ListNode head, int k)
    {
        ListNode l1 = head;
        while(k-->0)
        {
            l1 = l1.next;
        }
        return l1;
    }
    
    public boolean isPalindrome(ListNode head)
    {
        //BEST WAY
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast!=null)
            slow = slow.next;
        
        slow = reverse(slow);
        fast = head;
        while(slow!=null)
        {
            if(fast.val!=slow.val)
                return false;
            
            fast=fast.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        while(head!=null)
        {
            ListNode next = head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}
