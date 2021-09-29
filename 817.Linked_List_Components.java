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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> setG = new HashSet<>();
        for(int i:nums)
            setG.add(i);
        int res = 0;
        while(head!=null)
        {
            if(setG.contains(head.val) && (head.next==null || !setG.contains(head.next.val)))
                res++;
            head = head.next;
        }
        return res;
    }
}
