/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int s1 = getSize(headA);
        int s2 = getSize(headB);
        
        int diff = Math.max(s1,s2)-Math.min(s1,s2);
        if(s1>s2)
        {
            while(diff-->0)
            {
                headA = headA.next;
            }
        }
        else
        {
            while(diff-->0)
            {
                headB = headB.next;
            }
        }
        while(headA!=null)
        {
            if(headA==headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
        
    }
    public int getSize(ListNode head)
    {
        int size = 0;
        while(head!=null)
        {
            size++;
            head = head.next;
        }
        return size;
    }
}