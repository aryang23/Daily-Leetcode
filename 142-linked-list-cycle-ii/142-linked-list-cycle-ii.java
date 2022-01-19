/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode cycleNode = null;
        while(fast!=null && fast.next!=null)
        {
            
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
            {
                cycleNode = slow;
                break;
            }
        }
        if(cycleNode==null)
            return null;
        slow = head;
        while(slow!=cycleNode)
        {
            slow = slow.next;
            cycleNode = cycleNode.next;
        }
        return cycleNode;
    }
}