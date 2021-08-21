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
    private static ListNode th = null, tt = null;
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null)
            return head;
        int k = 2;
        
        int len = length(head);
        ListNode curr = head, oh = null, ot = null;
        while(len >= k)
        {
            int tempK = k;
            while(tempK-- > 0)
            {
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
            }
            if(oh==null)
            {
                oh = th;
                ot = tt;
            }
            else
            {
                ot.next = th;
                ot = tt;
            }
            th = tt = null;
            len -= k;
        }
        ot.next = curr;
        return oh;
    }
    
    public static int length(ListNode head)
    {
        if(head==null)
        {
            return 0;
        }

        int len = 0;
        ListNode curr = head;
        while(curr!=null)
        {
            curr = curr.next;
            len++;
        }
        return len;
    }
    
    
    public static void addFirstNode(ListNode node)
    {
        if(th==null)
            th = tt = node;
        else
        {
            node.next = th;
            th = node;
        }
    }
}
