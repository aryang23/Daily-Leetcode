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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0)
            return head;
        
        if(head == null || head.next==null)
            return head;
        
        int size = 0;
        ListNode tail = head;
        while(tail.next!=null)
        {
            tail = tail.next;
            size++;
        }
        size++;
        
        if(k==size)
            return head;
        if(k>size)
            k=k%size;
        if(k==0)
            return head;
        
        ListNode fast = head, slow = head;
        int t = k;
        while(t-->0)
        {
            fast=fast.next;
        }
        ListNode prev = null;
        while(fast!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        // slow = slow.next;
        // prev = prev.next;
        // System.out.println(prev.val);
        // System.out.println(slow.val);
        // System.out.println(fast.val);
        prev.next = null;
        tail.next = head;
        head = slow;
        return head;
    }
}
