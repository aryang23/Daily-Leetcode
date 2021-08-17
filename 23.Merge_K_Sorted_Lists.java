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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        ListNode ans = mergeKListsHelper(lists, 0, lists.length-1);
        return ans;
        
    }
    
    public ListNode mergeKListsHelper(ListNode[] lists, int si, int ei)
    {
        if(si==ei)
        {
            return lists[si];
        }
        
        int mid = (si+ei)/2;
        ListNode leftList = mergeKListsHelper(lists, si, mid);
        ListNode rightList = mergeKListsHelper(lists, mid+1, ei);
        
        return mergeTwoLists(leftList, rightList);
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if(l1==null)
        return l2;
        
        if(l2==null)
        return l1;
        
        ListNode dummy = new ListNode(-1);
        ListNode c = dummy;
        
        ListNode c1 = l1, c2 = l2;
        while(c1!=null && c2!=null)
        {
            if(c1.val<c2.val)
            {
                c.next = c1;
                c1 = c1.next;
            }
            else
            {
                c.next = c2;
                c2 = c2.next;
            }
            c = c.next;
        }
        c.next = (c1==null)?c2:c1;
        
        return dummy.next;
    }
}
