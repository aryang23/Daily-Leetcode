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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int N = 0;
        while(curr!=null)
        {
            curr = curr.next;
            N++;
        }
        
        int width = N/k;
        int rem = N%k;
        ListNode[] ans = new ListNode[k];
        curr = head;
        for(int i=0;i<k;i++)
        {
            ListNode head2 = new ListNode(0), write=head2;
            for(int j=0;j<width+(i<rem?1:0);j++)
            {
                write = write.next = new ListNode(curr.val);
                if(curr!=null)
                    curr = curr.next;
            }
            ans[i] = head2.next;
        }
        return ans;
        
        
    }
}
