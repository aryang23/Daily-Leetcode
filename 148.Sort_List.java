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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode mid = midNode(head);
        ListNode nhead = mid.next;
        mid.next = null;
        ListNode a = sortList(head);
        ListNode b = sortList(nhead);
        ListNode c = mergeTwoLists(a, b);
        return c;
        
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                curr.next=l1;
                l1=l1.next;
            }
            else
            {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null?l2:l1;
        return dummy.next;
    }
    
    
    public ListNode midNode(ListNode head)
    {
        ListNode slow = head, fast = head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
