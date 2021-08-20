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
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        head = reverse(head);
        long power = 1;
        while(head!=null)
        {
            int ld = head.val;
            ans += ld*power;
            power*=2;
            head = head.next;
        }
        return ans;
    }
    
    public static ListNode reverse(ListNode head) {
        if(head==null || head.next==null)
        return head;
        
        ListNode prev = null, curr = head;
        
        while(curr!=null)
        {
            ListNode currKaNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currKaNext;
        }
        return prev;
    }
}
