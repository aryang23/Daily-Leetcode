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
    public ListNode sortList2(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode mid = midNode(head);
        ListNode nhead = mid.next;
        mid.next = null;
        ListNode a = sortList(head);
        ListNode b = sortList(nhead);
        ListNode c = mergeTwoLists(a, b);
        return c;
        
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1!=null && l2!=null)
        {
            if(l1.val<=l2.val)
            {
                curr.next=l1;
                l1=l1.next;
            }
            else
            {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null?l2:l1;
        return dummy.next;
    }
    
    
    public ListNode midNode(ListNode head)
    {
        ListNode slow = head, fast = head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public static ListNode[] getSegregateNodes(ListNode head, int pivotIdx) {
        if (head == null || head.next == null)
            return new ListNode[] { null, head, null };

        ListNode pivotNode = head;
        while (pivotIdx-- > 0)
            pivotNode = pivotNode.next;

        ListNode smaller = new ListNode(-1), larger = new ListNode(-1), sp = smaller, lp = larger, curr = head;
        while (curr != null) {
            if (curr != pivotNode && curr.val <= pivotNode.val) {
                sp.next = curr;
                sp = sp.next;
            } else if (curr != pivotNode) {
                lp.next = curr;
                lp = lp.next;
            }

            curr = curr.next;
        }

        sp.next = lp.next = pivotNode.next = null;

        return new ListNode[] { smaller.next, pivotNode, larger.next };
    }


    public static ListNode[] quickSortMain(ListNode head) {
        if(head==null || head.next==null)
        return new ListNode[] {head, head};

        int len = getLength(head);
        ListNode[] segregateNodes = getSegregateNodes(head, len/2);

        ListNode[] left = quickSortMain(segregateNodes[0]);
        ListNode[] right = quickSortMain(segregateNodes[2]);

        return mergeLists(left, segregateNodes[1], right);
    }

    public static ListNode[] mergeLists(ListNode[] left, ListNode pivotNode,ListNode[] right)
    {
        ListNode fh = null, ft = null;
        if(left[0]!=null && right[0]!=null)
        {
            fh = left[0];
            left[1].next = pivotNode;
            pivotNode.next = right[0];
            ft = right[1];
        }
        else if(left[0]==null && right[0]==null)
        {
            fh = ft = pivotNode;
        }
        else if(left[0]==null)
        {
            fh = pivotNode;
            fh.next = right[0];
            ft = right[1];
        }
        else
        {
            fh = left[0];
            left[1].next = pivotNode;
            ft = pivotNode;
        }
        return new ListNode[] {fh, ft};
    }

    public static int getLength(ListNode head)
    {
        ListNode curr = head;
        int len = 0;
        while(curr!=null)
        {
            len++;
            curr = curr.next;
        }
        return len;
    }
    
    public ListNode sortList(ListNode head){
        ListNode[] ans = quickSortMain(head);
        
        return ans[0];
    }
}