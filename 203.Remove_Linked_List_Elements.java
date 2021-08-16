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
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead;
        fakeHead.next = head;
        ListNode curr = head;
        ListNode dum = head;
        
        while(curr!=null)
        {
            if(curr.val==val)
            prev.next = curr.next;
            else
            prev = curr;
            
            curr=curr.next;
        }
        return fakeHead.next;
    }
}
