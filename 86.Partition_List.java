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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next==null)
            return head;
        ListNode curr = head;
        ListNode smallHead = new ListNode(-1), largeHead = new ListNode(-1);
        ListNode sh = smallHead, lh = largeHead;
        while(curr!=null)
        {
            ListNode forw = curr.next;
            curr.next = null;
            if(curr.val<x)
            {
                sh.next = curr;
                sh = sh.next;
            }
            else
            {
                lh.next = curr;
                lh = lh.next;
            }
            curr = forw;
        }
        
        sh.next = largeHead.next;
        return smallHead.next;
    }
}
