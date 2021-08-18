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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left==right)
            return head;
        
        ListNode fakeHead = new ListNode(-1);
        ListNode prev = fakeHead;
        prev.next = head;
        ListNode curr = head;
        th = tt = null;
        
        int i = 1;
        while(i<=right)
        {
            while(i>=left && i<=right)
            {
                ListNode forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
                i++;
            }
            if(i>right)
            {
                prev.next = th;
                tt.next = curr;
                break;
            }
            prev = curr;
            curr = curr.next;
            i++;
        }
        return fakeHead.next;
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
