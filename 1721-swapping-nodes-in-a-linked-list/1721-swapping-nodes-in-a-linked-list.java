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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next==null)
            return head;
        
        int tempK = k-1;
        ListNode nodeOne = head;
        while(tempK-- > 0)
        {
            nodeOne = nodeOne.next;
        }
        
        ListNode fast = head, slow = head;
        tempK = k;
        while(tempK-- > 0)
        {
            fast = fast.next;
        }
        while(fast!=null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        // System.out.println(nodeOne.val);
        // System.out.println(slow.val);
        int temp = nodeOne.val;
        nodeOne.val = slow.val;
        slow.val = temp;
        return head;
    }
}