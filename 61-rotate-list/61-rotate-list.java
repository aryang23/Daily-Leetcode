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
        if(k == 0)
            return head;
        
        if(head == null || head.next==null)
            return head;
        
        int size = 0;
        ListNode tail = head;
        while(tail.next != null) {
            tail = tail.next;
            size++;
        }
        size++;
        
        if(k>size)
            k=k%size;
        if(k==0 || k==size)
            return head;
        
        ListNode fast = head, slow = head;
        int t = k;
        while(t-->0) {
            fast=fast.next;
        }
        
        ListNode prev = null;
        while(fast!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        
        prev.next = null;
        tail.next = head;
        head = slow;
        return head;
    }
}