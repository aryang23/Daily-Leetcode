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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode dh = new ListNode(-1);
        dh.next = head;
        ListNode prev = dh;
        ListNode curr = head;
        
        while(curr != null) {
            while(curr.next!=null && curr.val==curr.next.val)
            {
                ListNode forw = curr.next;
                curr.next = null;
                curr = forw;
            }
            if(prev.next != curr) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dh.next;
    }
}