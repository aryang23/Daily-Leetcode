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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode odd = new ListNode(-1), even = new ListNode(-1);
        ListNode op = odd, ep = even;
        ListNode curr = head;
        int i = 0;
        while(curr!=null)
        {
            if((i & 1)==0)
            {
                op.next = curr;
                op = op.next;
            }
            else
            {
                ep.next = curr;
                ep = ep.next;
            }
            curr = curr.next;
            i++;
        }
        ep.next = op.next = null;
        op.next = even.next;
        return odd.next;
        
    }
}
