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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode preHead = new ListNode(0);
        ListNode p = preHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) 
        {
            int sum = (l1==null?0:l1.val)+(l2==null?0:l2.val)+carry;
            carry = sum/10;
            p.next = new ListNode(sum%10);
            p = p.next;
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;

        }
        return preHead.next;
    }
}